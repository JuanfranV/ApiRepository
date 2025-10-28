package com.example.libreria.controllers;

import com.example.libreria.models.LibroModel;
import com.example.libreria.repositories.LibroRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/libros")
@CrossOrigin //opcional si se quiere consumir desde un front diferente
public class LibroController {

    private final LibroRepository libroRepository;

    public LibroController(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    //listar Autores
    @GetMapping
    public List<LibroModel> listar(){
        return libroRepository.findAll();
    }

    //obtener por id
    @GetMapping("{id}")
    public LibroModel obtener(@PathVariable int id){
        return libroRepository.findById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Libro no encontrado"));
    }

    //insertar
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LibroModel crear(@RequestBody LibroModel libro) {
        if (libro.getIdLibro() != 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El idLibro no debe contener ningún valor");
        }

        String nombre = libro.getNombre();
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre no puede estar vacío");
        }

        String nombreMinusculas = nombre.toLowerCase();
        if (nombreMinusculas.contains("select") || nombreMinusculas.contains("insert") || nombreMinusculas.contains("update")
                || nombreMinusculas.contains("delete") || nombreMinusculas.contains("<script>") || nombreMinusculas.contains("--")
                || nombreMinusculas.contains(";") || nombreMinusculas.contains("\\")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre contiene caracteres no permitidos");
        }

        return libroRepository.save(libro);
    }


    //modificar
    @PutMapping
    public LibroModel actualizar(@PathVariable Integer id, @RequestBody LibroModel libroRequest){
        LibroModel libro = libroRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Libro no encontrado"));

        libro.setNombre(libroRequest.getNombre());
        return libroRepository.save(libro);
    }






}
