package com.aula_23.secao_23_projeto_web_spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula_23.secao_23_projeto_web_spring.entities.Product;
import com.aula_23.secao_23_projeto_web_spring.repositories.ProductRepository;

/*Anotação para registrar a classe para @Autowired
 * @Component
 * @Repository
 * @Service como a classe é de serviço utilizaremos @Service*/

@Service
public class ProductService {

	@Autowired
	private ProductRepository userRepository;
	
	public List<Product> findAll(){
		return userRepository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = userRepository.findById(id);
		return obj.get();
	}

}
