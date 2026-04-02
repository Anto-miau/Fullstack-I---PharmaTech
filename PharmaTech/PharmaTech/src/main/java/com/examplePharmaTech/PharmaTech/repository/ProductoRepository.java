package com.examplePharmaTech.PharmaTech.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.examplePharmaTech.PharmaTech.model.Producto;

@Repository
public class ProductoRepository {

    private List <Producto> listaProductos = new ArrayList<>();

    //metodo permitir agregar, listar y eliminar productos, incluyendo nombre, precio y categoría. 

    //listar
    public List<Producto> obtenerProductos (){
        return listaProductos;
    }

//-----------------------------------------------------------------------
    public Producto buscarPorId(Integer id){
        for (Producto producto : listaProductos){
            if (producto.getId() == id){
                return producto;
            }
        }
        return null;
    }
        
//--------------------------------------------------------------

    //agregar
    public Producto guardar(Producto prod){
        listaProductos.add(prod);
        return prod;
    }

//--------------------------------------------------------------------------------------
    //por si acaso

    public Producto actualizar(Producto prod){
        for(int i = 0; i < listaProductos.size(); i++){
            if(listaProductos.get(i).getId() == prod.getId()){
                listaProductos.set(i,prod);
                return prod;   
            }
        }
        return null;
    }
//-------------------------------------------------------------------------------------------

//------------------------------------------------------------------------------------------

    public void eliminar(Integer id){
        Producto producto = buscarPorId(id);
        if (producto!=null){
            listaProductos.remove(producto);
        }
    }


}
