package com.webservices.project.repositories;

import com.webservices.project.entities.OrderItem;
import com.webservices.project.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
