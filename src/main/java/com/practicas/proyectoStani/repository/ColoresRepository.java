package com.practicas.proyectoStani.repository;

import com.practicas.proyectoStani.entity.ColoresEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("coloresRepository")
public interface ColoresRepository extends JpaRepository<ColoresEntity, Integer> {
}
