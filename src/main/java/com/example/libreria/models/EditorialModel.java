package com.example.libreria.models;

import jakarta.persistence.*;

@Entity
@Table(name = "editoriales")
public class EditorialModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEditorial;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String telefono;
    @Column(nullable = false)
    private String direccion;

    public EditorialModel(){

    }

    public EditorialModel(int idEditorial, String nombre, String telefono, String direccion) {
        this.idEditorial = idEditorial;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public int getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(int idEditorial) {
        this.idEditorial = idEditorial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
