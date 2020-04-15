package com.practicas.proyectoStani.controller;

import com.practicas.proyectoStani.entity.ProductoEntity;
import com.practicas.proyectoStani.model.ProductoModel;
import com.practicas.proyectoStani.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    @Qualifier("productoService")
    private ProductoService productoService;

    @GetMapping("/")
    private List<ProductoModel> getProductos(){
        return this.productoService.getProductos();
    }

    @GetMapping("/id/{id}")
    public ProductoModel getProductoId(@PathVariable("id") Integer codigo){
        return this.productoService.getProductoId(codigo);
    }

    @DeleteMapping("/delete/{id}")
    public void borrarProducto(@PathVariable("id") Integer codigo){
        this.productoService.borrarProductoByID(codigo);
    }

    @PostMapping("/add")
    public ProductoModel addProducto(@RequestBody ProductoModel producto){
        return this.productoService.addProducto(producto);
    }

    @PostMapping("/filtrar")
    public List<ProductoModel> filtrarPorCategoria(@RequestBody Integer codigo){
        return this.productoService.filtrarProductosPorCategoria(codigo);
    }
}
