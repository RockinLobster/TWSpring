package com.example.tema3.tema3.repository;

import com.example.tema3.tema3.models.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users, Long> {
    Users findByUsername(String username);
}
