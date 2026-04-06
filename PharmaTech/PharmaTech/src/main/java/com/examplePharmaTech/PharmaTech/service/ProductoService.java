package com.examplePharmaTech.PharmaTech.service;

import java.util.ArrayList;
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

    //----------- REGLAS DE NEGOCIO ------------------------------
    public Producto venderProducto(Integer id, String numeroReceta) {

    Producto producto = productoRepository.buscarPorId(id);

    if (producto == null) {
        return null;
    }

    // Validación receta
    if (producto.isReceta()) {
        if (numeroReceta == null || numeroReceta.isEmpty()) {
            return null;
        }
    }

    // Descontar stock
    producto.setStock(producto.getStock() - 1);

    // Alerta reposición
    if (producto.getStock() < 10) {
        producto.setAlertaReposicion(true);
    }

    return productoRepository.actualizar(producto);
    }

    //-------------------------------------------------------------
    public List<Producto> productosCriticos() {

    List<Producto> lista = new ArrayList<>();

    for (Producto p : productoRepository.obtenerProductos()) {
        if (p.getStock() < 5 && p.getTipo().equals("Crítico")) {
            lista.add(p);
        }
    }

        return lista;
    }

    
}
