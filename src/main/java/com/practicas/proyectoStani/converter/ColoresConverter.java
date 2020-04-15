package com.practicas.proyectoStani.converter;

import com.practicas.proyectoStani.entity.ColoresEntity;
import com.practicas.proyectoStani.entity.ProductoEntity;
import com.practicas.proyectoStani.model.ColoresModel;
import com.practicas.proyectoStani.model.ProductoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("coloresConverter")
public class ColoresConverter {

    @Autowired
    @Qualifier("productoConverter")
    ProductoConverter productoConverter;

    public ColoresModel entidadAModel(ColoresEntity coloresEntity){
        ColoresModel coloresModel = new ColoresModel();
        coloresModel.setCodigo(coloresEntity.getCodigo());
        coloresModel.setNombre(coloresEntity.getNombre());
        return coloresModel;
    }

    public ColoresEntity modeloAEntidad(ColoresModel coloresModel){
        ColoresEntity coloresEntity = new ColoresEntity();
        coloresEntity.setCodigo(coloresModel.getCodigo());
        coloresEntity.setNombre(coloresModel.getNombre());
        return coloresEntity;
    }
}
