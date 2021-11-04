/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.project;

import com.spboot.project.models.Transaksi;
import com.spboot.project.repositories.TransaksiRepository;
import com.spboot.project.services.TransaksiService;
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

/**
 *
 * @author ASUS
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc

public class TransaksiTest {
    @InjectMocks
    @Autowired
    TransaksiService service;

    @Mock
    TransaksiRepository repository;
     @Autowired
    private MockMvc mockMvc;
    
    
         @Test
    public void createTransaksiWithEmptyKaryawan() throws Exception {
        Throwable e = null;
        String message = null;
        
        try {
             Transaksi transaksi = new Transaksi();
        transaksi.setKaryawan("");
        transaksi.setPelanggan ("Kania");
        transaksi.setBerat ("7");
        transaksi.setJenis ("Pakaian");
        transaksi.setTarif(6000);
        transaksi.setTotal(42000);
           
            when(repository.save(transaksi))
                    .thenThrow(new Exception("please insert karyawan name"));
            service.tstore(transaksi);
        } catch (Exception ex) {
            e = ex;
            message = ex.getMessage();
        }
        
        Assertions.assertTrue(e instanceof Exception);
    }
    
     @Test
    public void createTransaksiWithEmptyPelanggan() throws Exception {
        Throwable e = null;
        String message = null;
        
        try {
             Transaksi transaksi = new Transaksi();
        transaksi.setKaryawan("Doni");
        transaksi.setPelanggan ("");
        transaksi.setBerat ("3");
        transaksi.setJenis ("Celana");
        transaksi.setTarif(6000);
        transaksi.setTotal(18000);
           
            when(repository.save(transaksi))
                    .thenThrow(new Exception("please insert pelanggan name"));
            service.tstore(transaksi);
        } catch (Exception ex) {
            e = ex;
            message = ex.getMessage();
        }
        
        Assertions.assertTrue(e instanceof Exception);
    }
    
     @Test
    public void createTransaksiWithEmptyJenis() throws Exception {
        Throwable e = null;
        String message = null;
        
        try {
             Transaksi transaksi = new Transaksi();
        transaksi.setKaryawan("Raihan");
        transaksi.setPelanggan ("Alika");
        transaksi.setBerat ("2");
        transaksi.setJenis ("Jaket");
        transaksi.setTarif(7000);
        transaksi.setTotal(14000);
           
            when(repository.save(transaksi))
                    .thenThrow(new Exception("please insert jenis barang"));
            service.tstore(transaksi);
        } catch (Exception ex) {
            e = ex;
            message = ex.getMessage();
        }
        
        Assertions.assertTrue(e instanceof Exception);
    }
}

