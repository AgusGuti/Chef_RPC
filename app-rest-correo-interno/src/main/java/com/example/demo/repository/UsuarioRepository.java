package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    public boolean existsByNombre(String nombre);

    public boolean existsById(Long id);
}
