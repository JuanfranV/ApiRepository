package com.example.libreria.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "ventas")
public class VentaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVenta;
    @Column(nullable = false)
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteModel clienteModel;

    @Column(nullable = false)
    private double total;

    public VentaModel(){

    }

    public VentaModel(int idVenta, Date fecha, double total, ClienteModel clienteModel) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.total = total;
        this.clienteModel = clienteModel;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ClienteModel getClienteModel() {
        return clienteModel;
    }

    public void setClienteModel(ClienteModel clienteModel) {
        this.clienteModel = clienteModel;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
