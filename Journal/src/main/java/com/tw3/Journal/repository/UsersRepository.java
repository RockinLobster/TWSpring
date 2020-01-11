package com.tw3.Journal.repository;

import com.tw3.Journal.models.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Long, Users> {
}
