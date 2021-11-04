/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.project;

import com.spboot.project.models.Karyawan;
import com.spboot.project.repositories.KaryawanRepository;
import com.spboot.project.services.KaryawanService;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 *
 * @author ASUS
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc

public class KaryawanTest {
    @InjectMocks
    @Autowired
    KaryawanService service;

    @Mock
    KaryawanRepository repository;
     @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void testCreateKaryawan() throws Exception{
        Karyawan karyawan = new Karyawan ();
        karyawan.setName("Fauzan");
        karyawan.setTelephone("0818293145");
               
        mockMvc.perform(post("/karyawan/kstore")
                .flashAttr("karyawan", karyawan))
                .andExpect(status().is3xxRedirection());           
    }
         @Test
    public void createKaryawanWithEmptyTelephone() throws Exception {
        Throwable e = null;
        String message = null;
        
        try {
             Karyawan karyawan = new Karyawan();
            karyawan.setName("Firyal");
            karyawan.setTelephone("");
           
            when(repository.save(karyawan))
                    .thenThrow(new Exception("please fill with telephone number"));
            service.kstore(karyawan);
        } catch (Exception ex) {
            e = ex;
            message = ex.getMessage();
        }
                Assertions.assertTrue(e instanceof Exception);
    }
}
