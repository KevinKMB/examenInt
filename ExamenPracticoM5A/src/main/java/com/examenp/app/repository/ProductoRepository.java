package com.examenp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examenp.app.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
