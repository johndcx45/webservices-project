package com.webservices.project.repositories;

import com.webservices.project.entities.Category;
import com.webservices.project.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
