package com.example.helloworld.controller;

import com.example.helloworld.Repository.ProductRepository;
import com.example.helloworld.exception.ProductNotFoundException;
import com.example.helloworld.model.Product;
import com.example.helloworld.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class productController {
    Logger logger = LoggerFactory.getLogger(productController.class);
    @Autowired
    private ProductService productService;
    @Autowired
    ProductRepository repo;

    @GetMapping
    public List<Product> list(){
        return repo.findAll();
    }
    @PostMapping("/AddProduct")
    public Product addProduct(@RequestBody @Valid Product product){
        return productService.addProduct(product);
    }

    @GetMapping("/getall")
    public List<Product> getProduct(){
        System.out.println("Get all");
        return productService.getProduct();
    }

    @DeleteMapping("deleteProduct/{id}")
    public String deleteTutorial(@PathVariable("id") @Valid int id ) {
        productService.deleteProduct(id);
        return "Product successfully deleted";
    }

    @PutMapping("/updateProduct/{id}")
    public Product updateProduct(@RequestBody Product product,
                     @PathVariable("id") int productId)
    {

        return productService.updateProduct(
                product, productId);
    }
    @PutMapping("/updateProductqty/{id}/{qty}")
    public Product updateProductqty(@PathVariable("id") int productId , @PathVariable("qty") int qty)
    {
        //To decrease set value as minus
        return productService.updateProductqty(productId,qty);

    }
    @GetMapping("/getProductById/{id}")
    public Product getProductById(@PathVariable("id") int productId) throws ProductNotFoundException {

        return productService.getProductById(productId);
    }


}
