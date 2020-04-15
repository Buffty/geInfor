package com.practicas.proyectoStani.service.impl;

import com.practicas.proyectoStani.converter.ProductoConverter;
import com.practicas.proyectoStani.entity.CategoriaEntity;
import com.practicas.proyectoStani.entity.ProductoEntity;
import com.practicas.proyectoStani.model.ProductoModel;
import com.practicas.proyectoStani.repository.CategoriaRepository;
import com.practicas.proyectoStani.repository.ProductoRepository;
import com.practicas.proyectoStani.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service("productoService")
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    @Qualifier("productoRepository")
    ProductoRepository productoRepository;

    @Autowired
    @Qualifier("categoriaRepository")
    CategoriaRepository categoriaRepository;

    @Autowired
    @Qualifier("productoConverter")
    ProductoConverter productoConverter;

    @Override
    public List<ProductoModel> getProductos() {
        List<ProductoModel> listaProducto = new ArrayList<ProductoModel>();
        for (ProductoEntity produc : this.productoRepository.findAll()) {
            listaProducto.add(this.productoConverter.entidadAModelo(produc));
        }
        return listaProducto;
    }

    @Override
    public ProductoModel getProductoId(Integer codigo) {
        ProductoModel producto;
        if (this.productoRepository.findById(codigo).isPresent()) {
                producto = this.productoConverter.entidadAModelo(this.productoRepository.findById(codigo).get());
                return producto;
            } else {
                return null;
            }
    }

    @Override
    public ProductoModel addProducto(ProductoModel producto) {
        ProductoEntity nuevoProducto = new ProductoEntity();
        nuevoProducto.setCodigo(this.productoRepository.findAll().get((int)this.productoRepository.count()-1).getCodigo()+1);
        nuevoProducto.setNombre(producto.getNombre());
        nuevoProducto.setFechaCreacion(Calendar.getInstance().getTime());
        this.productoRepository.save(nuevoProducto);
        return producto;
    }

    @Override
    public void borrarProductoByID(Integer codigo) {
        ProductoEntity producto;
        try{
            producto = this.productoRepository.findById(codigo).orElse(null);
            if(producto!=null){
                this.productoRepository.delete(producto);
            }
        }finally {
            producto = null;
        }
    }

    @Override
    public List<ProductoModel> filtrarProductosPorCategoria(Integer codigo) {
        List<ProductoModel> listaProductos;
        CategoriaEntity categoria;
        try{
            listaProductos = new ArrayList<>();
            categoria = this.categoriaRepository.findById(codigo).get();
            for (ProductoEntity product : categoria.getProductoList()) {
                listaProductos.add(this.productoConverter.entidadAModelo(product));
            }
            return listaProductos;
        }finally{
            listaProductos = null;
            categoria = null;
        }
    }
}
