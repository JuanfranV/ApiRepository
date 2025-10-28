package com.example.libreria.repositories;

import com.example.libreria.models.EditorialModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditorialRepository extends JpaRepository<EditorialModel, Integer> {
}
