package com.tw3.Journal.controllers;

import com.tw3.Journal.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserController  {

    @Autowired
    UsersRepository usersRepository;
}
