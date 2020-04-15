package com.practicas.proyectoStani.controller;

import com.practicas.proyectoStani.entity.ColoresEntity;
import com.practicas.proyectoStani.model.ColoresModel;
import com.practicas.proyectoStani.service.ColoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colores")
public class ColoresController {

    @Autowired
    @Qualifier("coloresService")
    private ColoresService coloresService;

    @GetMapping("/")
    private List<ColoresModel> getColores(){
        return this.coloresService.getListColores();
    }

    @GetMapping("/id/{id}")
    public ColoresModel getColoresId(@PathVariable("id")Integer codigo){
        return this.coloresService.getColoresById(codigo);
    }

    @DeleteMapping("/delete/{id}")
    public void borrarColores(@PathVariable("id") Integer codigo){
        this.coloresService.borrarColor(codigo);
    }

    @PostMapping("/add")
    public ColoresModel addColor(@RequestBody ColoresModel color){
        return this.coloresService.addColor(color);
    }
}
