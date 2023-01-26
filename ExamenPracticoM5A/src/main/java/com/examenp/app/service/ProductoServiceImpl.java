package com.examenp.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examenp.app.entity.Producto;
import com.examenp.app.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	private ProductoRepository productorepository;

	@Override
	@Transactional(readOnly=true)
	public Iterable<Producto> findAll() {
		return productorepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Producto> findAll(Pageable pageable) {
		return productorepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Producto> findById(Long cod) {
		return productorepository.findById(cod);
	}

	@Override
	@Transactional
	public Producto save(Producto producto) {
		return productorepository.save(producto);
	}

	@Override
	@Transactional
	public void deleteById(Long cod) {
		productorepository.deleteById(cod);
	}

}
