package com.aula_23.secao_23_projeto_web_spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula_23.secao_23_projeto_web_spring.entities.Category;
import com.aula_23.secao_23_projeto_web_spring.repositories.CategoryRepository;

/*Anotação para registrar a classe para @Autowired
 * @Component
 * @Repository
 * @Service como a classe é de serviço utilizaremos @Service*/

@Service
public class CategoryService {
	
	//@Autowired é para que o spring possa gerar a injeção de dependencia ao userRepository
	@Autowired
	private CategoryRepository userRepository;
	
	public List<Category> findAll(){
		return userRepository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = userRepository.findById(id);
		return obj.get();
	}

}
