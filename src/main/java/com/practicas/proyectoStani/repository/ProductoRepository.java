package com.practicas.proyectoStani.repository;

import com.practicas.proyectoStani.entity.ProductoEntity;
import com.practicas.proyectoStani.model.ProductoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("productoRepository")
public interface ProductoRepository extends JpaRepository<ProductoEntity,Integer> {
}
