/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.project.controllers;

/**
 *
 * @author ASUS
 */

import com.spboot.project.interfaces.JenisInterface;
import com.spboot.project.interfaces.KaryawanInterface;
import com.spboot.project.interfaces.PelangganInterface;
import com.spboot.project.interfaces.TransaksiInterface;
import com.spboot.project.models.Jenis;
import com.spboot.project.models.Karyawan;
import com.spboot.project.models.Pelanggan;
import com.spboot.project.models.Transaksi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TransaksiController {
    @Autowired 
    private TransaksiInterface transaksiInterface; 
    
    @Autowired 
    private KaryawanInterface karyawanInterface; 
    
    @Autowired 
    private JenisInterface jenisInterface; 
    
    @Autowired 
    private PelangganInterface pelangganInterface; 
 
    @GetMapping("/transaksi") 
    public String tindex(Model model) { 
        model.addAttribute("list", transaksiInterface.getAll()); 
        return "transaksi/tindex"; 
    } 
 
    @GetMapping("/transaksi/tcreate") 
    public String tcreate(Model model) { 
        List<Karyawan> karyawan = karyawanInterface.getAll();
        model.addAttribute("karyawan", karyawan);
        
        List<Pelanggan> pelanggan = pelangganInterface.getAll();
        model.addAttribute("pelanggan", pelanggan);
        
        List<Jenis> jenis = jenisInterface.getAll();
        model.addAttribute("jenis", jenis);
        
        Transaksi transaksi = new Transaksi(); 
        model.addAttribute("transaksi", transaksi); 
         
        return "transaksi/tcreate"; 
    } 
 
    @PostMapping("/transaksi/tstore") 
    public String tstore(@ModelAttribute("transaksi") Transaksi transaksi) { 
        transaksiInterface.tstore(transaksi); 
        return "redirect:/transaksi"; 
    } 
     
    @GetMapping("/transaksi/{id}/tedit") 
    public String tedit(@PathVariable(value = "id") long id, Model model) { 
         List<Karyawan> karyawan = karyawanInterface.getAll();
        model.addAttribute("karyawan", karyawan);
        
        List<Pelanggan> pelanggan = pelangganInterface.getAll();
        model.addAttribute("pelanggan", pelanggan);
        
        List<Jenis> jenis = jenisInterface.getAll();
        model.addAttribute("jenis", jenis);
        Transaksi transaksi = transaksiInterface.getById(id); 
 
        model.addAttribute("transaksi", transaksi); 
        return "transaksi/tedit"; 
    } 
 
    @PostMapping("/transaksi/{id}/delete") 
    public String delete(@PathVariable(value = "id") long id) { 
        transaksiInterface.delete(id); 
        return "redirect:/transaksi" ; 
    } 
    
}