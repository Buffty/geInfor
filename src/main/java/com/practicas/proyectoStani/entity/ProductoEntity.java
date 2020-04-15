package com.practicas.proyectoStani.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="PRODUCTO")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "ProductoEntity.findAll", query = "SELECT p FROM ProductoEntity p")})
public class ProductoEntity extends Producto{

    @ManyToMany(mappedBy = "productoList", fetch = FetchType.LAZY)
    private List<CategoriaEntity> categoriaList = new ArrayList<>();
    @JoinColumn(name = "COLOR", referencedColumnName = "CODIGO", nullable = false)
    @ManyToOne( fetch = FetchType.LAZY)
    private ColoresEntity color = new ColoresEntity();

    @XmlTransient
    public List<CategoriaEntity> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<CategoriaEntity> categoriaList) {
        this.categoriaList = categoriaList;
    }

    public ColoresEntity getColor() {
        return color;
    }

    public void setColor(ColoresEntity color) {
        this.color = color;
    }

    @Override
    public void setFechaCreacion(Date fechaCreacion) {
        Date fechaAnterior = Calendar.getInstance().getTime();
        fechaAnterior.setYear(1990);
        if(fechaCreacion.before(fechaAnterior)){
            super.setFechaCreacion(fechaCreacion);
        }else{
            super.setFechaCreacion(null);
        }
    }
}
