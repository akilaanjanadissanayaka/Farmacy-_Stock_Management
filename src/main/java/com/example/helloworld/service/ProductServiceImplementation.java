package com.example.helloworld.service;

import com.example.helloworld.Repository.ProductRepository;
import com.example.helloworld.exception.ProductNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.example.helloworld.model.Product;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class ProductServiceImplementation implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public String deleteProduct(int id) {
        productRepository.deleteById((int) id);
        return "success";
    }
//    http://localhost:8080/api/updateProduct/0
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


    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleEmail(String toEmail,
                                String subject,
                                String body
    ) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("akiladissanayaka255@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        mailSender.send(message);
        System.out.println("Mail Send...");


    }




    @Override
    public Product updateProductqty(int productId, int qty) {
        Product depDB = productRepository.findById(productId).get();
        int newQty= depDB.getQty()+qty;
        depDB.setQty(newQty);
        return productRepository.save(depDB);
    }

    @Override
    public List<Product> getProduct() {
        log.info("Get user details");
        return (List<Product>) productRepository.findAll();
    }


    @Override
    public Product addProduct(Product product) {
        sendSimpleEmail("akiladissanayaka255@gmail.com","Test subject",product.getName());
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(int productId) throws ProductNotFoundException {
        Product product= productRepository.getProductById(productId);
        if(product!= null){
            return product;
        }
        else {
            throw new ProductNotFoundException("Product not found id- "+productId);
        }
    }
}
