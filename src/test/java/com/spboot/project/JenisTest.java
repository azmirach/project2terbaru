/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.project;

import com.spboot.project.models.Jenis;
import com.spboot.project.repositories.JenisRepository;
import com.spboot.project.services.JenisService;
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

public class JenisTest {
    @InjectMocks
    @Autowired
    JenisService service;

    @Mock
    JenisRepository repository;
     @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void testCreateJenis() throws Exception{
        Jenis jenis = new Jenis ();
        jenis.setName("Handuk");
        jenis.setTarif(19000);
               
        mockMvc.perform(post("/jenis/jstore")
                .flashAttr("jenis", jenis))
                .andExpect(status().is3xxRedirection());
           }
         @Test
    public void createJenisWithEmptyName() throws Exception {
        Throwable e = null;
        String message = null;
        
        try {
             Jenis jenis = new Jenis();
            jenis.setName("");
            jenis.setTarif(19000);
           
            when(repository.save(jenis))
                    .thenThrow(new Exception("please enter your name"));
            service.jstore(jenis);
        } catch (Exception ex) {
            e = ex;
            message = ex.getMessage();
        }
               Assertions.assertTrue(e instanceof Exception);
    }
}
