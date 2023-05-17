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

        model.addAttribute("enumType", "Tops");
        model.addAttribute("order", order);
        model.addAttribute("user", userRepo.findByUsername(principal.getUsername()));
        return "shop";
    }
    @GetMapping("/tops")
    public String showOrderForm1(Model model) {
        Order order1 = new Order();
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        order1.setUser(userRepo.findByUsername(principal.getUsername()));

        List<Clothes> list = (List<Clothes>) clothesRepo.findAll();
        for (Clothes product : list) {
            order1.getOrderDetails().getOrderItems().add(new OrderItem(order1.getOrderDetails(), product, 0));
        }

        model.addAttribute("enumType", "Tops");
        model.addAttribute("order", order1);
        model.addAttribute("user", userRepo.findByUsername(principal.getUsername()));
        return "shop";
    }
    @GetMapping("/bottoms")
    public String showOrderForm2(Model model) {
        Order order2 = new Order();
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        order2.setUser(userRepo.findByUsername(principal.getUsername()));

        List<Clothes> list = (List<Clothes>) clothesRepo.findAll();
        for (Clothes product : list) {
            order2.getOrderDetails().getOrderItems().add(new OrderItem(order2.getOrderDetails(), product, 0));
        }

        model.addAttribute("enumType", "Bottoms");
        model.addAttribute("order", order2);
        model.addAttribute("user", userRepo.findByUsername(principal.getUsername()));
        return "shop";
    }
    @GetMapping("/dresses")
    public String showOrderForm3(Model model) {
        Order order3 = new Order();
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        order3.setUser(userRepo.findByUsername(principal.getUsername()));

        List<Clothes> list = (List<Clothes>) clothesRepo.findAll();
        for (Clothes product : list) {
            order3.getOrderDetails().getOrderItems().add(new OrderItem(order3.getOrderDetails(), product, 0));
        }

        model.addAttribute("enumType", "Dresses");
        model.addAttribute("order", order3);
        model.addAttribute("user", userRepo.findByUsername(principal.getUsername()));
        return "shop";
    }
    @GetMapping("/shoes")
    public String showOrderForm4(Model model) {
        Order order4 = new Order();
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        order4.setUser(userRepo.findByUsername(principal.getUsername()));

        List<Clothes> list = (List<Clothes>) clothesRepo.findAll();
        for (Clothes product : list) {
            order4.getOrderDetails().getOrderItems().add(new OrderItem(order4.getOrderDetails(), product, 0));
        }

        model.addAttribute("enumType", "Shoes");
        model.addAttribute("order", order4);
        model.addAttribute("user", userRepo.findByUsername(principal.getUsername()));
        return "shop";
    }
    @GetMapping("/accessories")
    public String showOrderForm5(Model model) {
        Order order5 = new Order();
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        order5.setUser(userRepo.findByUsername(principal.getUsername()));

        List<Clothes> list = (List<Clothes>) clothesRepo.findAll();
        for (Clothes product : list) {
            order5.getOrderDetails().getOrderItems().add(new OrderItem(order5.getOrderDetails(), product, 0));
        }

        model.addAttribute("enumType", "Accessories");
        model.addAttribute("order", order5);
        model.addAttribute("user", userRepo.findByUsername(principal.getUsername()));
        return "shop";
    }
    @GetMapping("/outwear")
    public String showOrderForm6(Model model) {
        Order order6 = new Order();
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        order6.setUser(userRepo.findByUsername(principal.getUsername()));

        List<Clothes> list = (List<Clothes>) clothesRepo.findAll();
        for (Clothes product : list) {
            order6.getOrderDetails().getOrderItems().add(new OrderItem(order6.getOrderDetails(), product, 0));
        }

        model.addAttribute("enumType", "OuterWear");
        model.addAttribute("order", order6);
        model.addAttribute("user", userRepo.findByUsername(principal.getUsername()));
        return "shop";
    }

    @PostMapping("/dresses")
    public String showCart1(@ModelAttribute Order order) {
        order.getOrderDetails().getOrderItems().removeIf(p -> p.getQuantity() == 0); // filter the products with zero quantities
        order.calculateSum();

        return "cart";
    }
    @PostMapping("/shoes")
    public String showCart2(@ModelAttribute Order order) {
        order.getOrderDetails().getOrderItems().removeIf(p -> p.getQuantity() == 0); // filter the products with zero quantities
        order.calculateSum();

        return "cart";
    }
    @PostMapping()
    public String showCart(@ModelAttribute Order order) {
        order.getOrderDetails().getOrderItems().removeIf(p -> p.getQuantity() == 0); // filter the products with zero quantities
        order.calculateSum();

        return "cart";
    }
    @PostMapping("/tops")
    public String showCart3(@ModelAttribute Order order) {
        order.getOrderDetails().getOrderItems().removeIf(p -> p.getQuantity() == 0); // filter the products with zero quantities
        order.calculateSum();

        return "cart";
    }
    @PostMapping("/bottoms")
    public String showCart4(@ModelAttribute Order order) {
        order.getOrderDetails().getOrderItems().removeIf(p -> p.getQuantity() == 0); // filter the products with zero quantities
        order.calculateSum();

        return "cart";
    }
    @PostMapping("/accessories")
    public String showCart5(@ModelAttribute Order order) {
        order.getOrderDetails().getOrderItems().removeIf(p -> p.getQuantity() == 0); // filter the products with zero quantities
        order.calculateSum();

        return "cart";
    }
    @PostMapping("/outwear")
    public String showCart6(@ModelAttribute Order order) {
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
