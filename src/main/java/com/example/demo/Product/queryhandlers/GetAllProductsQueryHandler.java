package com.example.demo.Product.queryhandlers;


import com.example.demo.Model.Product;
import com.example.demo.Product.ProductRepository;
import com.example.demo.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllProductsQueryHandler implements Query<Void, List<Product>> {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public ResponseEntity<List<Product>> execute(Void input) {
        return ResponseEntity.ok(productRepository.findAll());
    }
}
