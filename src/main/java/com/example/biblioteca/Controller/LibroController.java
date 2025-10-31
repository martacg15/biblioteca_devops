package com.example.biblioteca.Controller;

import com.example.biblioteca.Entity.Libro;
import com.example.biblioteca.service.LibroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (path = "/api")
public class LibroController {
    @Autowired
    private LibroServiceImpl libroServiceImpl; //se inyecta la dependencia

    @GetMapping
    private List<Libro> obtenerTodos(){
        return this.libroServiceImpl.getLibros();
    }

    @GetMapping("/{id}")
    public Optional<Libro> getLibro(@PathVariable Long id){
        return this.libroServiceImpl.getLibro(id);
    }

    @GetMapping
    void guardarOActualizarLibro(@RequestBody Libro libro){
        this.libroServiceImpl.guardarOActualizarLibro(libro);
    }

    @DeleteMapping("/{libroId}")
    void eliminarLibro(@PathVariable("libroId") Long libroId){
        this.libroServiceImpl.eliminarLibro(libroId);
    }
}
