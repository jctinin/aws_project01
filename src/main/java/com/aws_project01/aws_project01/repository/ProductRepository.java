package com.aws_project01.aws_project01.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aws_project01.aws_project01.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByName(String name);
    Optional<Product> findByCode(String code);

}
