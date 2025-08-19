package com.aws_project01.aws_project01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aws_project01.aws_project01.controller.service.ProductService;
import com.aws_project01.aws_project01.entity.Product;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/name/{name}")
  public ResponseEntity<List<Product>> findByName(@RequestParam String name) {

    ProductService productService = new ProductService();

    List<Product> response = productService.getProductByName(name);
    if (response == null) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(response);
  }

  @GetMapping("/id/{id}")
  public ResponseEntity<Product> findById(@RequestParam Long id) {

    Product response = productService.findById(id);

    return new ResponseEntity<Product>(response, HttpStatus.OK);

  }

  @PostMapping("/create")
  public ResponseEntity<Product> createProduct(@RequestBody Product produto) {

    Product prductCreated = productService.createProduct(produto);

    return new ResponseEntity<Product>(prductCreated, HttpStatus.CREATED);

  }

  @PutMapping("/{id}")
  public ResponseEntity<Product> updateProduct(@RequestBody Product produto, @RequestParam Long id) {
    Product updatedProduct = productService.updateProduct(produto, id);
    return new ResponseEntity<Product>(updatedProduct, HttpStatus.OK);

  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteProduct(@RequestParam Long id) {
    productService.findById(id);
    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
  }
}