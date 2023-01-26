package com.examenp.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examenp.app.entity.Producto;
import com.examenp.app.service.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

	@Autowired
	private ProductoService productoservice;
	
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Producto producto){
		
		if(producto.getCantidad()<=0) {
			}if(producto.getPrecio()<=0) {
				return ResponseEntity.notFound().build();
		}else {
			ResponseEntity.ok(producto);
			producto.setPreciototal(producto.getPrecio()*producto.getCantidad());
		return ResponseEntity.status(HttpStatus.CREATED).body(productoservice.save(producto));
		}
	}
	
	@GetMapping("/{cod}")
	public ResponseEntity<?> read(@PathVariable(value = "cod") Long cod){
		Optional<Producto> oProducto = productoservice.findById(cod);
		
		if(!oProducto.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oProducto);
	}
	
	
	
	@PutMapping("/{cod}")
	public ResponseEntity<?> update(@RequestBody Producto productoDetalles, @PathVariable(value="cod") Long cod){
		Optional<Producto> producto = productoservice.findById(cod);
		
		if(!producto.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		//BeanUtils.copyProperties(userDetails, user.get());
		producto.get().setDescripcion(productoDetalles.getDescripcion());
		producto.get().setPrecio(productoDetalles.getPrecio());
		producto.get().setCantidad(productoDetalles.getCantidad());
		producto.get().setPreciototal(productoDetalles.getPreciototal());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(productoservice.save(producto.get()));
		
	}
	
	@DeleteMapping("/{cod}")
	public ResponseEntity<?> delete (@PathVariable(value = "cod")Long cod){
		
		if(!productoservice.findById(cod).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		productoservice.deleteById(cod);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<Producto> readAll(){
		List<Producto> productos = StreamSupport.stream(productoservice.findAll().spliterator(), false).collect(Collectors.toList());
		return productos;
	}
}
