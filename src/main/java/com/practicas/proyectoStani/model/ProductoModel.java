package com.practicas.proyectoStani.model;

import com.practicas.proyectoStani.entity.CategoriaEntity;
import com.practicas.proyectoStani.entity.ColoresEntity;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ProductoModel {

    private Integer codigo;
    private String nombre;
    private Date fecha;

    public ProductoModel() {
    }

    public ProductoModel(String nombre, Date fecha) {
        this.nombre = nombre;
        this.fecha = Calendar.getInstance().getTime();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
}
