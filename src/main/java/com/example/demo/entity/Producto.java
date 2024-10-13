package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="tbl_producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;
    @Column(name="codigo", unique = true, nullable = false)
    private Integer code;
    private String nombre;
    private Double precioUnitario;
    private Integer cantidad;
    private String unidadMedida;

}
