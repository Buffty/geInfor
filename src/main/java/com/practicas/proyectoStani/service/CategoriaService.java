package com.practicas.proyectoStani.service;

import com.practicas.proyectoStani.entity.CategoriaEntity;
import com.practicas.proyectoStani.model.CategoriaModel;
import org.springframework.context.annotation.Lazy;

import java.util.List;
import java.util.Optional;

@Lazy
public interface CategoriaService {

    List<CategoriaModel> getListCategoria();

    CategoriaModel getCategoriaById(Integer dni);

    CategoriaModel addCategoria(CategoriaModel categoria);

    void borrarCategoria(Integer codigo);
}
