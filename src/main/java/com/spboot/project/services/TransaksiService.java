/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.project.services;

/**
 *
 * @author ASUS
 */

import com.spboot.project.models.Transaksi;
import com.spboot.project.repositories.TransaksiRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spboot.project.interfaces.TransaksiInterface;

@Service 
public class TransaksiService implements TransaksiInterface { 
    @Autowired 
    private TransaksiRepository transaksiRepository; 
     
    @Override 
    public List<Transaksi> getAll() { 
        return transaksiRepository.findAll(); 
    } 
 
    @Override 
    public void tstore(Transaksi transaksi) { 
        this.transaksiRepository.save(transaksi); 
    } 
     
    @Override 
    public Transaksi getById(long id) { 
        Optional < Transaksi > optional = transaksiRepository.findById(id); 
 
     if (!optional.isPresent()) { 
        throw new RuntimeException(" Transaksi not found for id : " + id); 
     } 
 
    Transaksi transaksi = optional.get(); 
    return transaksi; 
    } 
 
    @Override 
    public void delete(long id) { 
    this.transaksiRepository.deleteById(id); 
    } 
}    