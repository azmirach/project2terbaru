/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.project.controllers;

import com.spboot.project.interfaces.PelangganInterface;
import com.spboot.project.models.Pelanggan;
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
public class PelangganController { 
    @Autowired 
    private PelangganInterface pelangganInterface; 
 
    @GetMapping("/pelanggan") 
    public String pindex(Model model) { 
        model.addAttribute("list", pelangganInterface.getAll()); 
        return "pelanggan/pindex"; 
    } 
 
    @GetMapping("/pelanggan/pcreate") 
    public String pcreate(Model model) { 
        Pelanggan pelanggan = new Pelanggan(); 
        model.addAttribute("pelanggan", pelanggan); 
         
        return "pelanggan/pcreate"; 
    } 
 
    @PostMapping("/pelanggan/pstore") 
    public String pstore(@ModelAttribute("pelanggan") Pelanggan pelanggan) { 
        pelangganInterface.pstore(pelanggan); 
        return "redirect:/pelanggan/"; 
    } 
     
    @GetMapping("/pelanggan/{id}/pedit") 
    public String pedit(@PathVariable(value = "id") long id, Model model) { 
        Pelanggan pelanggan = pelangganInterface.getById(id); 
 
        model.addAttribute("pelanggan", pelanggan); 
        return "pelanggan/pedit"; 
    } 
 
    @PostMapping("/pelanggan/{id}/delete") 
    public String delete(@PathVariable(value = "id") long id) { 
        pelangganInterface.delete(id); 
        return "redirect:/pelanggan/" ; 
    } 
}
   