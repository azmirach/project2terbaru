/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.project.controllers;

import com.spboot.project.interfaces.KaryawanInterface;
import com.spboot.project.models.Karyawan;
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
public class KaryawanController { 
    @Autowired 
    private KaryawanInterface karyawanInterface; 
 
    @GetMapping("/karyawan") 
    public String kindex(Model model) { 
        model.addAttribute("list", karyawanInterface.getAll()); 
        return "karyawan/kindex"; 
    } 
 
    @GetMapping("/karyawan/kcreate") 
    public String kcreate(Model model) { 
        Karyawan karyawan = new Karyawan(); 
        model.addAttribute("karyawan", karyawan); 
         
        return "karyawan/kcreate"; 
    } 
 
    @PostMapping("/karyawan/kstore") 
    public String kstore(@ModelAttribute("karyawan") Karyawan karyawan) { 
        karyawanInterface.kstore(karyawan); 
        return "redirect:/karyawan/"; 
    } 
     
    @GetMapping("/karyawan/{id}/kedit") 
    public String kedit(@PathVariable(value = "id") long id, Model model) { 
        Karyawan karyawan = karyawanInterface.getById(id); 
 
        model.addAttribute("karyawan", karyawan); 
        return "karyawan/kedit"; 
    } 
 
    @PostMapping("/karyawan/{id}/delete") 
    public String delete(@PathVariable(value = "id") long id) { 
        karyawanInterface.delete(id); 
        return "redirect:/karyawan/" ; 
    } 
}
   
