package com.example.demo.service;

import com.example.demo.entity.Producto;
import com.example.demo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoSerivce {
    @Autowired
    ProductoRepository productoRepository;
    public List<Producto> getProduct(){
        return productoRepository.findAll();
    }

    public Optional<Producto> getProduct(Integer id){
        return productoRepository.findById(id);
    }

    public void saveOrUpdateProduct(Producto producto){
        productoRepository.save(producto);
    }

    public void deleteProduct(Integer id){
        productoRepository.deleteById(id);
    }
}
