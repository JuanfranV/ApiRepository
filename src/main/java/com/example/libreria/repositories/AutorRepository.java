package com.example.libreria.repositories;

import com.example.libreria.models.AutorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<AutorModel, Integer> {
}
