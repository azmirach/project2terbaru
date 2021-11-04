/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.project.services;

import com.spboot.project.interfaces.PelangganInterface;
import com.spboot.project.models.Pelanggan;
import com.spboot.project.repositories.PelangganRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service 
public class PelangganService implements PelangganInterface { 
    @Autowired 
    private PelangganRepository pelangganRepository; 
     
    @Override 
    public List<Pelanggan> getAll() { 
        return pelangganRepository.findAll(); 
    } 
 
    @Override 
    public void pstore(Pelanggan pelanggan) { 
        this.pelangganRepository.save(pelanggan); 
    } 
     
    @Override 
    public Pelanggan getById(long id) { 
        Optional < Pelanggan > optional = pelangganRepository.findById(id); 
 
     if (!optional.isPresent()) { 
        throw new RuntimeException(" Pelanggan not found for id : " + id); 
     } 
 
    Pelanggan pelanggan = optional.get(); 
    return pelanggan; 
    } 
 
    @Override 
    public void delete(long id) { 
    this.pelangganRepository.deleteById(id); 
    } 
}    
