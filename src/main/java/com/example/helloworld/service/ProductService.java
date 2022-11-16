package com.example.helloworld.service;

import com.example.helloworld.model.Product;

import java.util.List;

public interface ProductService {
    public Product addProduct(Product product);
    public String deleteProduct(int id);
    public List<Product> getProduct();
    public Product updateProduct(Product product, int productId);
    public Product updateProductqty( int productId,int qty);
    public Product getProductById( int productId);

}
