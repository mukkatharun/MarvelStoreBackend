package com.example.marvelstore.MarvelStore.Repository;

import com.example.marvelstore.MarvelStore.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Users findByEmail(String email);
    List<Users> findByActive(Boolean active);
}
