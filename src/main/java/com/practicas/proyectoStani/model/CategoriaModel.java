package com.practicas.proyectoStani.model;

import com.practicas.proyectoStani.entity.ProductoEntity;

import java.util.List;

public class CategoriaModel {
    private Integer codigo;
    private String nombre;
    public CategoriaModel() {
    }

    public CategoriaModel(Integer codigo, String nombre, List<ProductoModel> productoList) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
