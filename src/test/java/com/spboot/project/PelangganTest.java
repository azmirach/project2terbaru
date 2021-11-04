/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.project;

import com.spboot.project.models.Pelanggan;
import com.spboot.project.repositories.PelangganRepository;
import com.spboot.project.services.PelangganService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author ASUS
 */
    @ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc

public class PelangganTest {
    @InjectMocks
    @Autowired
    PelangganService service;

    @Mock
    PelangganRepository repository;
     @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void testCreatePelanggan() throws Exception{
        Pelanggan pelanggan = new Pelanggan ();
        pelanggan.setName("Nisrina");
        pelanggan.setTelephone("08125346790");
        pelanggan.setAlamat("Cipayung");
               
        mockMvc.perform(post("/pelanggan/pstore")
                .flashAttr("pelanggan", pelanggan))
                .andExpect(status().is3xxRedirection());
              
    }
         @Test
    public void createPelangganWithEmptyTelephone() throws Exception {
        Throwable e = null;
        String message = null;
        
        try {
             Pelanggan pelanggan = new Pelanggan();
           pelanggan.setName("Azizah");
        pelanggan.setTelephone("");
        pelanggan.setAlamat("Cibubur");
           
            when(repository.save(pelanggan))
                    .thenThrow(new Exception("please fill with telephone number"));
            service.pstore(pelanggan);
        } catch (Exception ex) {
            e = ex;
            message = ex.getMessage();
        }
                
        Assertions.assertTrue(e instanceof Exception);
        
         }
    
    @Test
    public void createPelangganWithEmptyAlamat() throws Exception {
        Throwable e = null;
        String message = null;
        
        try {
             Pelanggan pelanggan = new Pelanggan();
           pelanggan.setName("Raisa");
        pelanggan.setTelephone("08192736");
        pelanggan.setAlamat("");
           
            when(repository.save(pelanggan))
                    .thenThrow(new Exception("please fill with your address"));
            service.pstore(pelanggan);
        } catch (Exception ex) {
            e = ex;
            message = ex.getMessage();
            
        }
        Assertions.assertTrue(e instanceof Exception);
    }
    }