package com.example.marvelstore.MarvelStore.Controller;

import com.example.marvelstore.MarvelStore.Model.Product;
import com.example.marvelstore.MarvelStore.Model.Users;
import com.example.marvelstore.MarvelStore.ModelDTO.ProductDTO;
import com.example.marvelstore.MarvelStore.Repository.ProductRepository;
import com.example.marvelstore.MarvelStore.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping
    public List<Product> getAllProduct(@RequestParam(value = "category", required = false) String category){
        List<Product> products = category == null ? productRepository.findAll() : productRepository.findByCategory(category);
//        List<Product> products = productRepository.findAll();
        return products;
    }

    @GetMapping("/{id}")
    public Product getProductById(@RequestParam(value = "id") Integer id) {
        Product product = productRepository.getById(id);
        return product;
    }

    @GetMapping("/user")
    public List<Product> getProductsByUser(@RequestParam(value = "userid") Integer userid) {
        List<Product> products = productRepository.findAllByUsersId(userid);
        return products;
    }

    @PostMapping
    public Product saveProduct(@RequestBody ProductDTO productDTO){
        Users user = usersRepository.getById(productDTO.getUserid());
        Product product = new Product();
        product.setUsers(user);
        product.setCategory(productDTO.getCategory());
        product.setImage(productDTO.getImage());
        product.setPrice(productDTO.getPrice());
        product.setName(productDTO.getName());
        return productRepository.save(product);
    }
}
