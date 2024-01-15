package com.pawsoftedu.demo.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Utilizator")
public class Utilizator {
    private long id;
    private String nume;
    private String parola;

    public Utilizator () {
        
    }

    public Utilizator (String nume, String parola) {
        this.nume = nume;
        this.parola = parola;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId () {
        return id;
    }

    public void setId (long id) {
        this.id = id;
    }

    @Column(name = "nume", nullable = false)
    public String getNume () {
        return this.nume;
    }

    public void setNume (String nume) {
        this.nume = nume;
    }

    @Column(name = "parola", nullable = false)
    public String getParola () {
        return this.parola;
    }

    public void setParola (String parola) {
        this.parola = parola;
    }
}
