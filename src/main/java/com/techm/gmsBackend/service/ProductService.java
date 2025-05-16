package com.techm.gmsBackend.service;

import java.util.List;

import com.techm.gmsBackend.entity.GymProduct;
import org.springframework.stereotype.Service;

import com.techm.gmsBackend.dao.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String createOrUpdateProduct(GymProduct product) {
        productRepository.save(product);
        return "product created";
    }

    public List<GymProduct> getAllProducts() {
        return productRepository.findAll();
    }

    public GymProduct getProduct(long id) {
        return productRepository.findById(id).orElse(null);
    }

    public String deleteProduct(long id) {
        productRepository.deleteById(id);
        return "product deleted";
    }
}
