package com.example.demo.controller;

import com.example.demo.entity.Producto;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.service.ProductoSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path= "/producto")
public class productoController {
    @Autowired
    private ProductoSerivce productoSerivce;

    @GetMapping
    public List<Producto> getAll() {
        return productoSerivce.getProduct();
    }
    @GetMapping("/{personId}")
    public Optional<Producto> getById(@PathVariable("productId") Integer productId) {
        return productoSerivce.getProduct(productId);
    }


    @PostMapping
    public void saveUpdate(@RequestBody Producto producto) {
        productoSerivce.saveOrUpdateProduct(producto);
    }


    @DeleteMapping("/{personId}")
    public void saveUpdate(@PathVariable("personId") Integer productId) {
        productoSerivce.deleteProduct(productId);
    }

}
