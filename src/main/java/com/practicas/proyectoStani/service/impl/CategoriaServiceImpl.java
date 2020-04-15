package com.practicas.proyectoStani.service.impl;

import com.practicas.proyectoStani.converter.CategoriaConverter;
import com.practicas.proyectoStani.entity.CategoriaEntity;
import com.practicas.proyectoStani.entity.ProductoEntity;
import com.practicas.proyectoStani.model.CategoriaModel;
import com.practicas.proyectoStani.repository.CategoriaRepository;
import com.practicas.proyectoStani.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service("categoriaService")
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    @Qualifier("categoriaRepository")
    private CategoriaRepository categoriaRepository;

    @Autowired
    @Qualifier("categoriaConverter")
    CategoriaConverter categoriaConverter;

    @Override
    public List<CategoriaModel> getListCategoria() {
        List<CategoriaModel> listaCategoria = new ArrayList<>();
        for (CategoriaEntity categoriaEntity : this.categoriaRepository.findAll()) {
            listaCategoria.add(this.categoriaConverter.entidadAModelo(categoriaEntity));
        }
        return listaCategoria;
    }

    @Override
    public CategoriaModel getCategoriaById(Integer codigo) {
        CategoriaModel categoria;
        if(this.categoriaRepository.findById(codigo).isPresent()) {
            categoria = this.categoriaConverter.entidadAModelo(this.categoriaRepository.findById(codigo).orElse(null));
            return categoria;
        }else{
            return null;
        }

    }

    @Override
    public CategoriaModel addCategoria(CategoriaModel categoria) {
        this.categoriaRepository.save(this.categoriaConverter.modeloAEntidad(categoria));
        return categoria;
    }

    @Override
    public void borrarCategoria(Integer codigo) {
        CategoriaEntity categoriaEntity;
        try{
            categoriaEntity = this.categoriaRepository.findById(codigo).orElse(null);
            if(categoriaEntity!=null){
                this.categoriaRepository.delete(categoriaEntity);
            }
        }finally {
            categoriaEntity = null;
        }
    }

    // MÉTODO CON ENTITY MANAGER

    /*TypedQuery<Categoria> query = em.createQuery("select c from Categoria c where c.nombre=?1", Categoria.class);
        query.setParameter(1,nombre);
        List<Categoria> listaCategoria = query.getResultList();
        for (Categoria categoria : listaCategoria) {
            if(categoria.getNombre().equals(nombre)){
                this.categoriaRepository.delete(categoria);
            }
        }*/

}
