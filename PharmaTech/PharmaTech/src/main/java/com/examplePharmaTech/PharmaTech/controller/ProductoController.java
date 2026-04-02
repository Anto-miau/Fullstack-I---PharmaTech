package com.examplePharmaTech.PharmaTech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examplePharmaTech.PharmaTech.model.Producto;
import com.examplePharmaTech.PharmaTech.service.ProductoService;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> listaProducto(){
        return productoService.getProductos();
    }

    @PostMapping
    public Producto agregarEquipaje(@RequestBody Producto producto){
        return productoService.saveProducto(producto);
    }

    @GetMapping("{id}")
    public Producto buscarEquipaje(@PathVariable Integer id){
        return productoService.getProducto(id);
    }

    @PutMapping("{id}")
    public Producto actualizarProducto(@PathVariable Integer id, @RequestBody Producto producto){
        return productoService.updateProducto(producto);
    }

    @DeleteMapping("{id}")
    public String eliminarEquipaje(@PathVariable Integer id){
        return productoService.deleteProducto(id);
    }

}
