package com.aws_project01.aws_project01.entity;

import jakarta.persistence.*;

@Table(name = "products", uniqueConstraints = @UniqueConstraint(columnNames = "code"))
@Entity
public class Product {

  public Product(Long id, String name, String model, String code, double price) {
    this.id = id;
    this.name = name;
    this.model = model;
    this.code = code;
    this.price = price;
  }


  public Product() {
  }



  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name", nullable = false, length = 100)
  private String name;

  @Column(name = "model", nullable = false, length = 50)
  private String model;

  @Column(name = "code", nullable = false, unique = true, length = 20)
  private String code;

  private double price;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }



}
