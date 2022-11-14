package com.example.helloworld.controller;


import com.example.helloworld.Repository.ProductRepository;
import com.example.helloworld.model.Product;
import com.example.helloworld.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class productController {
    @Autowired
    private ProductService productService;

    @PostMapping("/AddProduct")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @GetMapping("/getall")
    public List<Product> getProduct(){
        return productService.getProduct();
    }

    @DeleteMapping("deleteProduct/{id}")
    public void deleteTutorial(@PathVariable("id") int id ) {
        productService.deleteProduct(id);
    }

    @PutMapping("/updateProduct/{id}")
    public Product updateProduct(@RequestBody Product product,
                     @PathVariable("id") int productId)
    {

        return productService.updateProduct(
                product, productId);
    }


}
