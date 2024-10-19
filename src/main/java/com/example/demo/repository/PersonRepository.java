package com.example.demo.repository;

import com.example.demo.entity.Persona;
import com.example.demo.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Persona, Integer> {
}
