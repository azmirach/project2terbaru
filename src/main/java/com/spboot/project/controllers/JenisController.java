/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.project.controllers;

import com.spboot.project.interfaces.JenisInterface;
import com.spboot.project.models.Jenis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ASUS
 */
@Controller
public class JenisController {
    @Autowired 
    private JenisInterface jenisInterface; 
 
    @GetMapping("/jenis") 
    public String jindex(Model model) { 
        model.addAttribute("list", jenisInterface.getAll()); 
        return "jenis/jindex"; 
    } 
 
    @GetMapping("/jenis/jcreate") 
    public String jcreate(Model model) { 
        Jenis jenis = new Jenis(); 
        model.addAttribute("jenis", jenis); 
         
        return "jenis/jcreate"; 
    } 
 
    @PostMapping("/jenis/jstore") 
    public String jstore(@ModelAttribute("jenis") Jenis jenis) { 
        jenisInterface.jstore(jenis); 
        return "redirect:/jenis"; 
    } 
     
    @GetMapping("/jenis/{id}/jedit") 
    public String jedit(@PathVariable(value = "id") long id, Model model) { 
        Jenis jenis = jenisInterface.getById(id); 
 
        model.addAttribute("jenis", jenis); 
        return "jenis/jedit"; 
    } 
 
    @PostMapping("/jenis/{id}/delete") 
    public String delete(@PathVariable(value = "id") long id) { 
        jenisInterface.delete(id); 
        return "redirect:/jenis" ; 
    } 
    
}
