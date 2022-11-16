package com.example.helloworld.Repository;

import com.example.helloworld.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository <Product,Integer> {

    @Query(value = "SELECT * FROM product where id=?1", nativeQuery = true)
    Product getProductById(int productId);

}
