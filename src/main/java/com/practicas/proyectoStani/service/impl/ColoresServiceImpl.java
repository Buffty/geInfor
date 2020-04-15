package com.practicas.proyectoStani.service.impl;

import com.practicas.proyectoStani.converter.ColoresConverter;
import com.practicas.proyectoStani.entity.ColoresEntity;
import com.practicas.proyectoStani.model.ColoresModel;
import com.practicas.proyectoStani.repository.ColoresRepository;
import com.practicas.proyectoStani.service.ColoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("coloresService")
public class ColoresServiceImpl implements ColoresService {

    @Autowired
    @Qualifier("coloresRepository")
    private ColoresRepository coloresRepository;

    @Autowired
    @Qualifier("coloresConverter")
    private ColoresConverter coloresConverter;

    @Override
    public List<ColoresModel> getListColores() {
        List<ColoresModel> listaColores = new ArrayList<>();
        for (ColoresEntity coloresEntity : this.coloresRepository.findAll()) {
            listaColores.add(this.coloresConverter.entidadAModel(coloresEntity));
        }
        return listaColores;
    }

    @Override
    public ColoresModel getColoresById(Integer codigo) {
        ColoresModel color;
        if(this.coloresRepository.findById(codigo).isPresent()) {
            color = this.coloresConverter.entidadAModel(this.coloresRepository.findById(codigo).get());
            return color;
        }else{
            return null;
        }

    }

    @Override
    public ColoresModel addColor(ColoresModel color) {
        this.coloresRepository.save(this.coloresConverter.modeloAEntidad(color));
        return color;
    }

    @Override
    public void borrarColor(Integer codigo) {
        ColoresEntity coloresEntity;
        try{
            coloresEntity = this.coloresRepository.findById(codigo).orElse(null);
            if(coloresEntity!=null){
                this.coloresRepository.delete(coloresEntity);
            }
        }finally {
            coloresEntity = null;
        }
    }
}
