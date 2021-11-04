/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.project.interfaces;

import com.spboot.project.models.Jenis;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface JenisInterface {

    List<Jenis> getAll();

    void jstore(Jenis jenis);

    Jenis getById(long id);

    void delete(long id);
}

