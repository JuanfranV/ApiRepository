package com.example.libreria.models;


import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class AutorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAutores")
    private int idAutores;
    @Column(nullable = false)
    private String nombre;

    public AutorModel() {
    }

    public AutorModel(int idAutores, String nombre) {
        this.idAutores = idAutores;
        this.nombre = nombre;
    }

    public int getIdAutores() {
        return idAutores;
    }

    public void setIdAutores(int idAutores) {
        this.idAutores = idAutores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
