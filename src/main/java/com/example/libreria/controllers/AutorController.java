package com.example.libreria.controllers;

import com.example.libreria.models.AutorModel;
import com.example.libreria.repositories.AutorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/autores")
@CrossOrigin //opcional si se quiere consumir desde un front diferente
public class AutorController {

    private final AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    //listar Autores
    @GetMapping
    public List<AutorModel> listar(){
        return autorRepository.findAll();
    }

    //obtener por id
    @GetMapping("{id}")
    public AutorModel obtener(@PathVariable int id){
        return autorRepository.findById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Autor no encontrado"));
    }

    //insertar
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AutorModel crear(@RequestBody AutorModel autor) {
        if (autor.getIdAutores() != 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El idAutor no debe contener ningún valor");
        }

        String nombre = autor.getNombre();
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre no puede estar vacío");
        }

        String nombreMinusculas = nombre.toLowerCase();
        if (nombreMinusculas.contains("select") || nombreMinusculas.contains("insert") || nombreMinusculas.contains("update")
                || nombreMinusculas.contains("delete") || nombreMinusculas.contains("<script>") || nombreMinusculas.contains("--")
                || nombreMinusculas.contains(";") || nombreMinusculas.contains("\\")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre contiene caracteres no permitidos");
        }

        return autorRepository.save(autor);
    }


    //modificar
    @PutMapping
    public AutorModel actualizar(@PathVariable Integer id, @RequestBody AutorModel autorRequest){
        AutorModel autor = autorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Autor no encontrado"));

        autor.setNombre(autorRequest.getNombre());
        return autorRepository.save(autor);
    }






}
