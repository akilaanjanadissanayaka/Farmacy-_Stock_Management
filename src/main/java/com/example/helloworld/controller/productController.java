package com.example.helloworld.controller;


import com.example.helloworld.Repository.ProductRepository;
import com.example.helloworld.exception.ProductNotFoundException;
import com.example.helloworld.model.Product;
import com.example.helloworld.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class productController {
    @Autowired
    private ProductService productService;

    @PostMapping("/AddProduct")
    public Product addProduct(@RequestBody @Valid Product product){
        return productService.addProduct(product);
    }

    @GetMapping("/getall")
    public List<Product> getProduct(){
        return productService.getProduct();
    }

    @DeleteMapping("deleteProduct/{id}")
    public void deleteTutorial(@PathVariable("id") @Valid int id ) {
        productService.deleteProduct(id);
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
