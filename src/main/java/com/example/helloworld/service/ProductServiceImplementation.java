package com.example.helloworld.service;

import com.example.helloworld.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.helloworld.model.Product;

import java.util.List;
import java.util.Objects;

@Service
public class ProductServiceImplementation implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public String deleteProduct(int id) {
        productRepository.deleteById((int) id);
        return "success";
    }

    @Override
    public Product updateProduct(Product product, int productId) {
        Product depDB = productRepository.findById(productId).get();
        if (Objects.nonNull(product.getName()) && !"".equalsIgnoreCase(product.getName())) {
            depDB.setName(product.getName());
        }
        if (Objects.nonNull(product.getCategory()) && !"".equalsIgnoreCase(product.getCategory())) {
            depDB.setCategory(product.getCategory());
        }

        return productRepository.save(depDB);
    }

    @Override
    public List<Product> getProduct() {
        return (List<Product>) productRepository.findAll();
    }


    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }


}
