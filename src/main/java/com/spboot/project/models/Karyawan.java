package com.spboot.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="karyawan") 
public class Karyawan { 
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    private long id; 
     
    @Column(name="name") 
    private String name; 
     
    @Column(name="telephone") 
    private String telephone; 
 
    public void setName(String name) { 
        this.name = name; 
    } 
 
    public String getName() { 
        return name; 
    } 
 
    public void setId(long id) { 
        this.id = id; 
    } 
 
    public long getId() { 
        return id; 
    } 
     
    public String getTelephone() { 
        return telephone; 
    } 
 
    public void setTelephone(String telephone) { 
        this.telephone = telephone; 
    } 
     
}