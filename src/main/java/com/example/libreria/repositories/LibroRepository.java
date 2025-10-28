package com.example.libreria.repositories;

import com.example.libreria.models.LibroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<LibroModel, Integer> {
}
