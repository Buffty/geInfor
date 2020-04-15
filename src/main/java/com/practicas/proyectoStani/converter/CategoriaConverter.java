package com.practicas.proyectoStani.converter;

import com.practicas.proyectoStani.entity.CategoriaEntity;
import com.practicas.proyectoStani.entity.ProductoEntity;
import com.practicas.proyectoStani.model.CategoriaModel;
import com.practicas.proyectoStani.model.ProductoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("categoriaConverter")
public class CategoriaConverter {

    @Autowired
    @Qualifier("productoConverter")
    ProductoConverter productoConverter;

    public CategoriaModel entidadAModelo(CategoriaEntity categoriaEntity){
        CategoriaModel categoriaModel = new CategoriaModel();
        categoriaModel.setCodigo(categoriaEntity.getCodigo());
        categoriaModel.setNombre(categoriaEntity.getNombre());
        return categoriaModel;
    }
    public CategoriaEntity modeloAEntidad(CategoriaModel categoriaModel){
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setCodigo(categoriaModel.getCodigo());
        categoriaEntity.setNombre(categoriaModel.getNombre());
        return categoriaEntity;
    }
}
