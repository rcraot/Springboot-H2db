package com.demo.h2db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.h2db.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
