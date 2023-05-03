package com.ust.aws.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.speedment.jpastreamer.application.*;
import com.ust.aws.Exception.BlogAlreadyExist;
import com.ust.aws.Exception.NoUserFoundException;
import com.ust.aws.Iface.AwsIface;
import com.ust.aws.resource.Product;
@Service
public class services {
	@Autowired
	AwsIface repo;
	@Autowired	
	private JPAStreamer jpa;

	public List<Product> create(List<Product> product) {
		
		return repo.saveAll(product);
	}
	
	public Product fetchproduct(long id) {
		 Optional<Product>p=repo.findById(id);
		if(p.isEmpty()) {
			throw new BlogAlreadyExist("hi anwar");
		}
		return repo.findById(id).orElse(null);
		// TODO Auto-generated method stub
		
	}

	public List<Product> Fetchall() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Product updatepr(Product product) {
	
		Product pr=null;
		Optional<Product> prod=repo.findById(product.getId());
		if(prod.isPresent()) {
			pr=prod.get();
			pr.setDescription(product.getDescription());
			pr.setPower(product.getPower());
			pr.setName(product.getName());
			pr.setFaction(product.getFaction());
			pr.setPos(product.getPos());
			repo.save(pr);
		}
		else {
			repo.save(product);
			return product;
		}
		return pr;
		
	

		}

	public boolean deleteproduct(long id) {
		Optional<Product> prod=repo.findById(id);
		if(!prod.isPresent())
			throw new NoUserFoundException("The given"+id+"doesnot exist");
		
		repo.deleteById(id);
		return true;
		
	}


	/*public List<Product> sortPower(int power) {
		return jpa.stream(Product.class)
				.filter(Product.power.Equals(power)).collect(Collectors.toList());
			
		}*/
		// TODO Auto-generated method stub
		
	}

