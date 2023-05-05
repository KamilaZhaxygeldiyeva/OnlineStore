package com.kamila.online_store.repos;

import com.kamila.online_store.entities.Order;
import com.kamila.online_store.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends CrudRepository<Order, Integer> {
    List<Order> findAllByUser(User user);
}
