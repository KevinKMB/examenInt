package com.examenp.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.examenp.app.entity.Producto;

public interface ProductoService {

public Iterable<Producto> findAll();
	
	public Page<Producto> findAll(Pageable pageable);
	
	public Optional<Producto> findById(Long cod);
	
	public Producto save(Producto producto);
	
	public void deleteById(Long cod);
}
