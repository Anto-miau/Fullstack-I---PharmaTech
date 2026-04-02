package com.examplePharmaTech.PharmaTech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examplePharmaTech.PharmaTech.model.Producto;
import com.examplePharmaTech.PharmaTech.repository.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getProductos() {
        return productoRepository.obtenerProductos();
    }

    public Producto saveProducto(Producto producto) {
        return productoRepository.guardar(producto);
    }

    public Producto updateProducto(Producto producto) {
        return productoRepository.actualizar(producto);
    }

    // public string para devolver mensaje

    public String deleteProducto(Integer id) {
        productoRepository.eliminar(id);
        return "Producto eliminado";
    }

    public Producto getProducto(Integer id) {
        return productoRepository.buscarPorId(id);
    }

}
