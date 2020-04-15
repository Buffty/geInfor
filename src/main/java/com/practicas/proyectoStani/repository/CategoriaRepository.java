package com.practicas.proyectoStani.repository;

import com.practicas.proyectoStani.entity.CategoriaEntity;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("categoriaRepository")
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Integer> {

}
