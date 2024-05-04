package com.example.ejercicio6.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "regions")
public class Regions {

    @Id
    @Column(name = "region_id")
    private int id;
    @Column(name = "region_name")
    private String regioname;

    public int getid() {
        return id;
    }

    public void setRegionid(int id) {
        this.id = id;
    }

    public String getRegioname() {
        return regioname;
    }

    public void setRegioname(String regioname) {
        this.regioname = regioname;
    }
}