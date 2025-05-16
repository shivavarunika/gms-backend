package com.techm.gmsBackend.controller;

import java.util.List;

import com.techm.gmsBackend.entity.GymProduct;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techm.gmsBackend.service.ProductService;

@RestController
@RequestMapping("/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add-update")
    public String addProduct(@RequestBody GymProduct product) {
        return productService.createOrUpdateProduct(product);
    }

    @GetMapping("/get-all")
    public List<GymProduct> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/get-id/{id}")
    public GymProduct getProductById(@PathVariable long id) {
        return productService.getProduct(id);
    }

    @DeleteMapping("/delete-id/{id}")
    public String deleteById(@PathVariable long id) {
        return productService.deleteProduct(id);
    }
}
