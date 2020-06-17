package com.example.productmanagement.repository;

import com.example.productmanagement.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
