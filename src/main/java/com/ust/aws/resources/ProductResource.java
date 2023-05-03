package com.ust.aws.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.aws.resource.Product;
import com.ust.aws.services.services;



@RestController
@RequestMapping("/abc")
public class ProductResource {
	@Autowired
	services service;
	@PostMapping
	@RequestMapping("/create")
	public List<Product> addproduct(@RequestBody List<Product> product){
	return service.create(product);
	}
	@GetMapping
	@RequestMapping("/retrieve/{id}")
	public Product fetch(long Id) {
		return service.fetchproduct(Id);
	}
	@GetMapping
	@RequestMapping("/retrieve")
	public List<Product> fetchall() {
		return service.Fetchall();
	}
	
	@PutMapping
	@RequestMapping("/update")
	public Product update(@RequestBody Product product )
	{
		return service.updatepr(product);
		
	}
	@DeleteMapping
	@RequestMapping("/delete/{id}")
	public boolean delete(@PathVariable long id) {
		return service.deleteproduct(id);
	}/*@GetMapping
	@RequestMapping("/sort/{power}")
	public List<Product> sort(@PathVariable double power){
		return service.sortPower(power);
		
	}*/
	
	
	

}
