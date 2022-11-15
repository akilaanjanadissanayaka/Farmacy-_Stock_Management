package com.example.helloworld.model;
import com.sun.istack.NotNull;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name",nullable = false)
    @NotNull
    private String name;

    @Column(name = "Category",nullable = false)
    private String Category;

    @Column(name = "qty",nullable = false)
    private int qty;

    public Product() {
    }
    public int getId() {
        return id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }


}
