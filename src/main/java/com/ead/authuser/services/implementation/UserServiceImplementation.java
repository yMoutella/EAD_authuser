package com.ead.authuser.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ead.authuser.repositories.UserRepository;

@Service
public class UserServiceImplementation {

    @Autowired
    UserRepository userRepository;
}
