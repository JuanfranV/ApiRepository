package com.example.libreria.controllers;

import com.example.libreria.models.EditorialModel;
import com.example.libreria.repositories.EditorialRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/editoriales")
@CrossOrigin //opcional si se quiere consumir desde un front diferente
public class EditorialController {

    private final EditorialRepository editorialRepository;

    public EditorialController(EditorialRepository editorialRepository) {
        this.editorialRepository = editorialRepository;
    }

    //listar Autores
    @GetMapping
    public List<EditorialModel> listar(){
        return editorialRepository.findAll();
    }

    //obtener por id
    @GetMapping("{id}")
    public EditorialModel obtener(@PathVariable int id){
        return editorialRepository.findById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Editorial no encontrado"));
    }

    //insertar
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EditorialModel crear(@RequestBody EditorialModel editorial) {
        if (editorial.getIdEditorial() != 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El idEditorial no debe contener ningún valor");
        }

        String nombre = editorial.getNombre();
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre no puede estar vacío");
        }

        String nombreMinusculas = nombre.toLowerCase();
        if (nombreMinusculas.contains("select") || nombreMinusculas.contains("insert") || nombreMinusculas.contains("update")
                || nombreMinusculas.contains("delete") || nombreMinusculas.contains("<script>") || nombreMinusculas.contains("--")
                || nombreMinusculas.contains(";") || nombreMinusculas.contains("\\")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre contiene caracteres no permitidos");
        }

        return editorialRepository.save(editorial);
    }


    //modificar
    public EditorialModel actualizar(@PathVariable Integer id, @RequestBody EditorialModel editorialRequest){
        EditorialModel editorial = editorialRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Autor no encontrado"));

        editorial.setNombre(editorialRequest.getNombre());
        return editorialRepository.save(editorial);
    }






}
