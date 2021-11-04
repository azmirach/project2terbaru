/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.project.services;

import com.spboot.project.interfaces.KaryawanInterface;
import com.spboot.project.models.Karyawan;
import com.spboot.project.repositories.KaryawanRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service 
public class KaryawanService implements KaryawanInterface { 
    @Autowired 
    private KaryawanRepository karyawanRepository; 
     
    @Override 
    public List<Karyawan> getAll() { 
        return karyawanRepository.findAll(); 
    } 
 
    @Override 
    public void kstore(Karyawan karyawan) { 
        this.karyawanRepository.save(karyawan); 
    } 
     
    @Override 
    public Karyawan getById(long id) { 
        Optional < Karyawan > optional = karyawanRepository.findById(id); 
 
     if (!optional.isPresent()) { 
        throw new RuntimeException(" Karyawan not found for id : " + id); 
     } 
 
    Karyawan karyawan = optional.get(); 
    return karyawan; 
    } 
 
    @Override 
    public void delete(long id) { 
    this.karyawanRepository.deleteById(id); 
    } 
}
   