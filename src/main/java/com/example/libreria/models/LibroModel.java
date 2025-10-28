package com.example.libreria.models;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class LibroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLibro;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private int edicion;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private AutorModel autorModel;
    @ManyToOne
    @JoinColumn(name = "editorial_id", nullable = false)
    private EditorialModel editorialModel;

    @Column(nullable = false)
    private int existencia;

    public LibroModel(){

    }

    public LibroModel(int idLibro, String nombre, AutorModel autorModel, int edicion, EditorialModel editorialModel, int existencia) {
        this.idLibro = idLibro;
        this.nombre = nombre;
        this.autorModel = autorModel;
        this.edicion = edicion;
        this.editorialModel = editorialModel;
        this.existencia = existencia;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdicion() {
        return edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public EditorialModel getEditorialModel() {
        return editorialModel;
    }

    public void setEditorialModel(EditorialModel editorialModel) {
        this.editorialModel = editorialModel;
    }

    public AutorModel getAutorModel() {
        return autorModel;
    }

    public void setAutorModel(AutorModel autorModel) {
        this.autorModel = autorModel;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }
}
