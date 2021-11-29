package com.example.marvelstore.MarvelStore.Controller;

import com.example.marvelstore.MarvelStore.Model.Users;
import com.example.marvelstore.MarvelStore.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/users")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping
    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }

    @GetMapping("/{id}")
    public Users getUserById(@PathVariable(value = "id") Integer id) {
        return usersRepository.getById(id);
    }

    @PostMapping
    public Users saveUser(@RequestBody Users user){
        return usersRepository.save(user);
    }

    @DeleteMapping
    public String deleteUser(@RequestParam(value = "userid", required = true) Integer userid) {
        usersRepository.deleteById(userid);
        return "Successfully deleted User " + userid;
    }

}
