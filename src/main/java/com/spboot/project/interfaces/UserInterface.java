/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.project.interfaces;

import com.spboot.project.models.User;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface UserInterface {
    List<User> getAll();
    void register(User user) throws Exception;
    User auth(String email, String password) throws Exception;
}
