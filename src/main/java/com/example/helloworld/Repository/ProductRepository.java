package com.example.helloworld.Repository;

import com.example.helloworld.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product,Integer> {

}
