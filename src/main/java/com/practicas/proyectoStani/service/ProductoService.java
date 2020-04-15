package com.practicas.proyectoStani.service;

import com.practicas.proyectoStani.entity.ProductoEntity;
import com.practicas.proyectoStani.model.ProductoModel;

import java.util.List;
public interface ProductoService {

    List<ProductoModel> getProductos();

    ProductoModel getProductoId(Integer codigo);

    ProductoModel addProducto(ProductoModel producto);

    void borrarProductoByID(Integer codigo);

    List<ProductoModel> filtrarProductosPorCategoria(Integer codigo);

}
