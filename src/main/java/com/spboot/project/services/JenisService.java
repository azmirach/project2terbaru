/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.project.services;

import com.spboot.project.interfaces.JenisInterface;
import com.spboot.project.models.Jenis;
import com.spboot.project.repositories.JenisRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
    @Service 
public class JenisService implements JenisInterface { 
    @Autowired 
    private JenisRepository jenisRepository; 
     
    @Override 
    public List<Jenis> getAll() { 
        return jenisRepository.findAll(); 
    } 
 
    @Override 
    public void jstore(Jenis jenis) { 
        this.jenisRepository.save(jenis); 
    } 
     
    @Override 
    public Jenis getById(long id) { 
        Optional < Jenis > optional = jenisRepository.findById(id); 
 
     if (!optional.isPresent()) { 
        throw new RuntimeException(" Jenis not found for id : " + id); 
     } 
 
    Jenis jenis = optional.get(); 
    return jenis; 
    } 
 
    @Override 
    public void delete(long id) { 
    this.jenisRepository.deleteById(id); 
    } 
    }