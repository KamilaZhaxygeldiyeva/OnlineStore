package com.kamila.online_store.Controllers;

import com.kamila.online_store.entities.Clothes;
import com.kamila.online_store.entities.Order;
import com.kamila.online_store.entities.OrderItem;
import com.kamila.online_store.repos.OrderRepo;
import com.kamila.online_store.repos.ClothesRepo;
import com.kamila.online_store.repos.UserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/shop")
@SessionAttributes({"order", "user"})
public class ShopController {
    private ClothesRepo clothesRepo;
    private OrderRepo orderRepo;
    private UserRepo userRepo;

    public ShopController(ClothesRepo clothesRepo, OrderRepo orderRepo, UserRepo userRepo) {
        this.clothesRepo = clothesRepo;
        this.orderRepo = orderRepo;
        this.userRepo = userRepo;
    }

    @GetMapping
    public String showOrderForm(Model model) {
        Order order = new Order();
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        order.setUser(userRepo.findByUsername(principal.getUsername()));

        List<Clothes> list = (List<Clothes>) clothesRepo.findAll();
        for (Clothes product : list) {
            order.getOrderDetails().getOrderItems().add(new OrderItem(order.getOrderDetails(), product, 0));
        }

        model.addAttribute("order", order);
        model.addAttribute("user", userRepo.findByUsername(principal.getUsername()));
        return "shop";
    }

    @PostMapping
    public String showCart(@ModelAttribute Order order) {
        order.getOrderDetails().getOrderItems().removeIf(p -> p.getQuantity() == 0); // filter the products with zero quantities
        order.calculateSum();

        return "cart";
    }

    @GetMapping("/purchase")
    @Transactional
    public String purchase(@ModelAttribute Order order, Model model) {
        try {
            if (order.getSum() == 0) {
                throw new RuntimeException("Error! Your cart is empty");
            }

            if (order.getSum() > order.getUser().getMoneyBalance()) {
                throw new RuntimeException("Error! Not enough money on your balance");
            }
        } catch (RuntimeException exc) {
            model.addAttribute("msg", exc.getMessage());
            return "cart";
        }

        // products in stock subtraction
        order.getOrderDetails().getOrderItems()
                .forEach(orderItem -> orderItem.getProduct()
                        .setInStock(orderItem.getProduct().getInStock() - orderItem.getQuantity()));

        // money subtraction
        order.getUser().setMoneyBalance(order.getUser().getMoneyBalance() -
                order.getSum());

        // saving to the DB
        order.getOrderDetails().getOrderItems().forEach(orderItem -> clothesRepo.save(orderItem.getProduct()));
        orderRepo.save(order);
        userRepo.save(order.getUser());
        return "thanks";
    }
}
