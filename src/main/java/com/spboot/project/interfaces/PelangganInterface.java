/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.project.interfaces;

import com.spboot.project.models.Pelanggan;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface PelangganInterface {
    List<Pelanggan> getAll();
    void pstore(Pelanggan pelanggan);
    Pelanggan getById(long id);
    void delete(long id);
    
}
