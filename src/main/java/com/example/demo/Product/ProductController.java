package com.example.demo.Product;

import com.example.demo.Model.Product;
import com.example.demo.Product.queryhandlers.GetAllProductsQueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private GetAllProductsQueryHandler getAllProductsQueryHandler;


    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return getAllProductsQueryHandler.execute(null);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getProduct(@PathVariable Integer id){
        return ResponseEntity.ok(productRepository.findById(id));

    }
    @PostMapping
    public ResponseEntity createProduct(@RequestBody Product product){
       productRepository.save(product);
       return ResponseEntity.ok().build();
    }
    @PutMapping ("/{id}")
    public ResponseEntity updateProduct(@PathVariable Integer id, @RequestBody Product product){
        product.setId(id);
        productRepository.save(product);
        return ResponseEntity.ok().build();

    }
    @DeleteMapping ("/{id}")
    public ResponseEntity deleteProduct (@PathVariable Integer id){
        Product product=productRepository.findById(id).get();
        productRepository.delete(product);
        return ResponseEntity.ok().build();
    }
}
