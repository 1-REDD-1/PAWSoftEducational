package com.pawsoftedu.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MaterialCurs")
public class MaterialCurs {
    private long id;
    private String denumire;
    private byte[] date;
    private String dataIntroducerii;

    public MaterialCurs () {
        
    }

    public MaterialCurs (String denumire, byte[] date, String dataIntroducerii) {
        this.denumire = denumire;
        this.date = date;
        this.dataIntroducerii = dataIntroducerii;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId () {
        return this.id;
    }

    public void setId (long id) {
        this.id = id;
    }

    @Column(name = "denumire", nullable = false)
    public String getDenumire () {
        return this.denumire;
    }

    public void setDenumire (String denumire) {
        this.denumire = denumire;
    }

    @Column(name = "date", nullable = false)
    public byte[] getDate () {
        return this.date;
    }

    public void setDate (byte[] date) {
        this.date = date;
    }

    @Column(name = "dataIntroducerii", nullable = false)
    public String getDataIntroducerii () {
        return this.dataIntroducerii;
    }

    public void setDataIntroducerii (String dataIntroducerii) {
        this.dataIntroducerii = dataIntroducerii;
    }
}