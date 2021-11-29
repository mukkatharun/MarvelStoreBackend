package com.example.marvelstore.MarvelStore.Controller;

import com.example.marvelstore.MarvelStore.Model.Cart;
import com.example.marvelstore.MarvelStore.Model.Orders;
import com.example.marvelstore.MarvelStore.Model.Product;
import com.example.marvelstore.MarvelStore.Model.Users;
import com.example.marvelstore.MarvelStore.ModelDTO.CartDTO;
import com.example.marvelstore.MarvelStore.Repository.CartRepository;
import com.example.marvelstore.MarvelStore.Repository.ProductRepository;
import com.example.marvelstore.MarvelStore.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Cart> getAllOrders(@RequestParam(value = "userid", required = true) Integer userid) {
        List<Cart> cartList = cartRepository.findAllByActiveAndUsersId( true, userid);
        return cartList;
    }

    @PostMapping
    public Cart saveToCart(@RequestBody CartDTO order){
        Users user = usersRepository.getById(order.getUserid());
        Product product = productRepository.getById(order.getProductid());
        Cart cart = new Cart();
        cart.setActive(true);
        cart.setPname(order.getPname());
        cart.setQuantity(1);
        cart.setUsers(user);
        cart.setProductid(product);

        return cartRepository.save(cart);
    }

    @DeleteMapping
    public String deleteItem(@RequestParam(value = "cartid", required = true) Integer cartid) {
        cartRepository.deleteById(cartid);
        return "Product has been removed from the cart";
    }
}
