/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.project.services;

import com.spboot.project.interfaces.UserInterface;
import com.spboot.project.models.User;
import com.spboot.project.repositories.UserRepository;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class UserService implements UserInterface {
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void register(User user) throws Exception {
        String hashed = this.hash(user.getPassword());
        user.setPassword(hashed);
        
        this.userRepository.save(user);
    }

    @Override
    public User auth(String email, String password) throws Exception {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            return null;
        }

        if (!this.match(user.getPassword(), password)) {
            return null;
        }

        return user;
    }

    private String hash(String password) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");

        byte[] messageDiggest = md.digest(password.getBytes());

        BigInteger no = new BigInteger(1, messageDiggest);

        String hashText = no.toString(16);
        while (hashText.length() < 32) {
            hashText = "0" + hashText;
        }

        return hashText;
    }

    private boolean match(String password, String rawPassword)
            throws Exception {
        rawPassword = this.hash(rawPassword);
        return password.equals(rawPassword);
    }
}
