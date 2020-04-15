package com.practicas.proyectoStani.converter;

import com.practicas.proyectoStani.entity.CategoriaEntity;
import com.practicas.proyectoStani.entity.ColoresEntity;
import com.practicas.proyectoStani.entity.ProductoEntity;
import com.practicas.proyectoStani.model.CategoriaModel;
import com.practicas.proyectoStani.model.ProductoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("productoConverter")
public class ProductoConverter {

    @Autowired
    @Qualifier("coloresConverter")
    ColoresConverter coloresConverter;

    @Autowired
    @Qualifier("categoriaConverter")
    CategoriaConverter categoriaConverter;

    public ProductoModel entidadAModelo(ProductoEntity productoEntity){
        ProductoModel productoModel = new ProductoModel();
        productoModel.setCodigo(productoEntity.getCodigo());
        productoModel.setNombre(productoEntity.getNombre());
        productoModel.setFecha(productoEntity.getFechaCreacion());
        return productoModel;
    }

    public ProductoEntity modeloAEntidad(ProductoModel productoModel){
        ProductoEntity productoEntity = new ProductoEntity();
        productoEntity.setCodigo(productoModel.getCodigo());
        productoEntity.setNombre(productoModel.getNombre());
        productoEntity.setFechaCreacion(productoModel.getFecha());
        return productoEntity;
    }
}
