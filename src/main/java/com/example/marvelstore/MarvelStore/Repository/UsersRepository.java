package com.example.marvelstore.MarvelStore.Repository;

import com.example.marvelstore.MarvelStore.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}
