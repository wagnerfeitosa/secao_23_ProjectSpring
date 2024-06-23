package com.aula_23.secao_23_projeto_web_spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula_23.secao_23_projeto_web_spring.entities.User;
import com.aula_23.secao_23_projeto_web_spring.repositories.UserRepository;

/*Anotação para registrar a classe para @Autowired
 * @Component
 * @Repository
 * @Service como a classe é de serviço utilizaremos @Service*/

@Service
public class UserService {
	
	//@Autowired é para que o spring possa gerar a injeção de dependencia ao userRepository
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) {
		return userRepository.save(obj);
	}
	
	public void delete(Long id) {
		userRepository.deleteById(id);
	}

}
