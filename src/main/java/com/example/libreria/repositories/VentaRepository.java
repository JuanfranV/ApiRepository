package com.example.libreria.repositories;

import com.example.libreria.models.VentaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<VentaModel, Integer> {
}
