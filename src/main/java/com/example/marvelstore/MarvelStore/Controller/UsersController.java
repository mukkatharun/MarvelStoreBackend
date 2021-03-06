package com.example.marvelstore.MarvelStore.Controller;

import com.example.marvelstore.MarvelStore.Model.Users;
import com.example.marvelstore.MarvelStore.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@CrossOrigin
@RestController
@RequestMapping("api/users")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping
    public List<Users> getAllUsers(){
        return usersRepository.findByActive(true);
    }

    @GetMapping("/{user}")
    public Users getUserByEmail(@RequestParam(value = "email") String email) {
        return usersRepository.findByEmail(email);
    }

    @PostMapping
    public Users saveUser(@RequestBody Users user){
        return usersRepository.save(user);
    }

    @DeleteMapping
    public String deleteUser(@RequestParam(value = "userid", required = true) Integer userid) {
        Users user =  usersRepository.getById(userid);
        user.setActive(false);
        usersRepository.save(user);
        return "Successfully deleted User " + userid;
    }

}
