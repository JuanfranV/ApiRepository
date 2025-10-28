package com.example.libreria.models;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_ventas")
public class DetalleVentaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalleV;

    @ManyToOne
    @JoinColumn(name = "venta_id", nullable = false)
    private VentaModel ventaModel;
    @ManyToOne
    @JoinColumn(name = "libro_id", nullable = false)

    private LibroModel libroModel;
    @Column(nullable = false)
    private int cantidad;
    @Column(nullable = false)
    private double subtotal;

    public DetalleVentaModel(){

    }

    public DetalleVentaModel(int idDetalleV, VentaModel ventaModel, LibroModel libroModel, int cantidad, double subtotal) {
        this.idDetalleV = idDetalleV;
        this.ventaModel = ventaModel;
        this.libroModel = libroModel;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public int getIdDetalleV() {
        return idDetalleV;
    }

    public void setIdDetalleV(int idDetalleV) {
        this.idDetalleV = idDetalleV;
    }

    public VentaModel getVentaModel() {
        return ventaModel;
    }

    public void setVentaModel(VentaModel ventaModel) {
        this.ventaModel = ventaModel;
    }

    public LibroModel getLibroModel() {
        return libroModel;
    }

    public void setLibroModel(LibroModel libroModel) {
        this.libroModel = libroModel;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
