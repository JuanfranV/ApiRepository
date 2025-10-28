package com.example.libreria.repositories;

import com.example.libreria.models.DetalleVentaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleVentaRepository extends JpaRepository<DetalleVentaModel, Integer> {
}
