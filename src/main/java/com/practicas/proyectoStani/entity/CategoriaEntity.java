package com.practicas.proyectoStani.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="CATEGORIA")
@XmlRootElement
@Lazy
@NamedQueries({
        @NamedQuery(name = "CategoriaEntity.findAll", query = "SELECT c FROM CategoriaEntity c")})
public class CategoriaEntity extends Categoria implements Serializable {

    @JoinTable(name = "PRODUCTO_CATEGORIA", joinColumns = {
            @JoinColumn(name = "CODIGO_CATEGORIA", referencedColumnName = "CODIGO", nullable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "CODIGO_PRODUCTO", referencedColumnName = "CODIGO", nullable = false)})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<ProductoEntity> productoList = new ArrayList<>();

    @XmlTransient
    public List<ProductoEntity> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<ProductoEntity> productoList) {
        this.productoList = productoList;
    }

}
