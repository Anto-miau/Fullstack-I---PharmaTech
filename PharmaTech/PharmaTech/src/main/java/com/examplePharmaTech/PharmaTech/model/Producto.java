package com.examplePharmaTech.PharmaTech.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Producto {

    @NotNull
    private Integer id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String tipo;

    @NotNull
    private Integer stock;

    private boolean receta;

}
