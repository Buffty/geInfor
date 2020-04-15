package com.practicas.proyectoStani.entity;

import javax.persistence.*;

@MappedSuperclass
public class Categoria{
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO", nullable = false)
    private Integer codigo;
    @Column(name = "NOMBRE", length = 20)
    private String nombre;


    public Categoria() {
    }

    public Categoria(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd.Categoria[ codigo=" + codigo + " ]";
    }
}
