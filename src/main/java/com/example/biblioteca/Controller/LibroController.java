package com.example.biblioteca.Controller;

import com.example.biblioteca.Entity.Libro;
import com.example.biblioteca.service.LibroServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class LibroController {

    @Autowired
    private LibroServiceImpl lsi;

    @GetMapping
    private List<Libro> obtenerTodos(){
        return this.lsi.getLibros();
    }

    @GetMapping("/{id}")
    public Optional<Libro> getLibro(@PathVariable Long id){

        return this.lsi.getLibro(id);
    }

    @PostMapping
    void guardarOActualizarLibro(@RequestBody Libro libro){

        this.lsi.guardarOActualizarLibro(libro);
    }

    @DeleteMapping("/{libroId}")
    void eliminarLibro(@PathVariable("libroId") Long libroId){
        this.lsi.eliminarLibro(libroId);
    }
}
