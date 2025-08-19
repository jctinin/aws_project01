package com.aws_project01.aws_project01.controller.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aws_project01.aws_project01.entity.Product;
import com.aws_project01.aws_project01.exception.ProductNotFoundException;
import com.aws_project01.aws_project01.repository.ProductRepository;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public List<Product> getProductByName(String name) {

    List<Product> products = productRepository.findByName(name);
    if (products.isEmpty()) {
      return null; // or throw an exception if preferred
    }
    return products;
  }

  public Optional<Product> findByCode(String code) {

    if (code == null || code.isEmpty()) {
      return Optional.empty();
    }

    return productRepository.findByCode(code);

  }

  public Product findById(Long id) {
    return productRepository.findById(id)
        .orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found."));

  }

  public Product createProduct(Product produto) {
    Optional<Product> existingProduct = productRepository.findByCode(produto.getCode());
    if (existingProduct.isPresent()) {
      throw new ProductNotFoundException("Product with code " + produto.getCode() + " already exists.");
    }
    return productRepository.save(produto);
  }

  public Product updateProduct(Product produto, Long id) {
    if (id == null) {
      throw new IllegalArgumentException("Product ID cannot be null for update.");
    }
    return productRepository.save(produto);
  }
}
