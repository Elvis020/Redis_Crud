package com.elvisdoingredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/product")
public class CrudWithRedisApplication {

	@Autowired
	private ProductDao productDao;

	@PostMapping
	public Product_Entity save(@RequestBody Product_Entity product_entity){
		return productDao.save(product_entity);
	}

	@GetMapping
	public List<Product_Entity> findAll(){
		return productDao.findAll();
	}

	@GetMapping("/{id}")
	public Product_Entity findProductById(@PathVariable int id){
		return productDao.findProductById(id);
	}

	@DeleteMapping("/{id}")
	public String remove(@PathVariable int id){
		return productDao.deleteProduct(id);
	}


	public static void main(String[] args) {
		SpringApplication.run(CrudWithRedisApplication.class, args);


	}




}
