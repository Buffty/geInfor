package com.practicas.proyectoStani.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

@Entity
@Table(name="COLORES")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "ColoresEntity.findAll", query = "SELECT c FROM ColoresEntity c")})
public class ColoresEntity extends Colores{
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "color", fetch = FetchType.LAZY)
    private List<ProductoEntity> productoList;

    @XmlTransient
    public List<ProductoEntity> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<ProductoEntity> productoList) {
        this.productoList = productoList;
    }

}
