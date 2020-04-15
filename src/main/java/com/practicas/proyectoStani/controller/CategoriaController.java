package com.practicas.proyectoStani.controller;

import com.practicas.proyectoStani.entity.CategoriaEntity;
import com.practicas.proyectoStani.model.CategoriaModel;
import com.practicas.proyectoStani.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/categoria")

public class CategoriaController {

    @Autowired
    @Qualifier("categoriaService")
    private CategoriaService categoriaService;

    @GetMapping("/")
    private List<CategoriaModel> getCategorias(){
        return this.categoriaService.getListCategoria();
    }

    @GetMapping("/id/{id}")
    public CategoriaModel getCategoriaId(@PathVariable("id") Integer codigo){
        return this.categoriaService.getCategoriaById(codigo);
    }

    @DeleteMapping("/delete/{id}")
    public void borrarCategoria(@PathVariable("id") Integer codigo){
        this.categoriaService.borrarCategoria(codigo);
    }

    @PostMapping("/add")
    public CategoriaModel addCategoria(@RequestBody CategoriaModel categoria){
        return this.categoriaService.addCategoria(categoria);
    }



}
