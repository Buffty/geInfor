package com.practicas.proyectoStani.entity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;


@MappedSuperclass
public class Producto{

    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO", nullable = false)
    private Integer codigo;
    @Column(name = "NOMBRE", length = 20)
    private String nombre;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

    public Producto() {
    }

    public Producto(Integer codigo) {
        this.codigo = codigo;
        this.fechaCreacion = Calendar.getInstance().getTime();
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
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd.Producto[ codigo=" + codigo + " ]";
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
