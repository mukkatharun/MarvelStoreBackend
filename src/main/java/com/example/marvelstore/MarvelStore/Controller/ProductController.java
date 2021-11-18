package com.example.marvelstore.MarvelStore.Controller;

import com.example.marvelstore.MarvelStore.Model.Product;
import com.example.marvelstore.MarvelStore.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProduct(){
        List<Product> a = productRepository.findAll();
        return a;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable(value = "id") Integer id) {
        Product p = productRepository.getById(id);
        return p;
    }

//    @PostMapping
//    public Product saveProduct(@RequestBody Product product){
//        return productRepository.save(product);
//    }
}
