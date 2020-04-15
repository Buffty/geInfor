package com.practicas.proyectoStani.service;

import com.practicas.proyectoStani.model.ColoresModel;

import java.util.List;

public interface ColoresService {
    List<ColoresModel> getListColores();

    ColoresModel getColoresById(Integer dni);

    ColoresModel addColor(ColoresModel categoria);

    void borrarColor(Integer codigo);
}
