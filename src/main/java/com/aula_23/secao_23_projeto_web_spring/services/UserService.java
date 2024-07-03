package com.aula_23.secao_23_projeto_web_spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.aula_23.secao_23_projeto_web_spring.entities.User;
import com.aula_23.secao_23_projeto_web_spring.repositories.UserRepository;
import com.aula_23.secao_23_projeto_web_spring.services.exceptions.DataBaseException;
import com.aula_23.secao_23_projeto_web_spring.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
	/*obj.orAlseThrow() tentará dar o Get,se não tiver o id da busca 
	 * Lançará e excecao personalizada que recebe um id utilizando expressão lanbda*/
	public User findById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return userRepository.save(obj);
	}
	public void delete(Long id) {
		try{
			userRepository.deleteById(id);
			/*Não encontrando o id para deletar lancará a seguinte excecao personalizada*/
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
			/*Excecao de violação de integfridade será criada 
			 * uma classe especifica para trastar essa excecao*/ 
		}catch(DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}
	/*retorn User atualizado recebendo Long id para indicar qual dados será
	 * atualizado e User dados que será o dado atualizado*/
	public User update(Long id,User obj) {
		try{
			/*pegando entidade na base de dados*/
			User entity = userRepository.getReferenceById(id);
			/*metodo que realiza a atualização*/
			updateData(entity,obj);
			/*salvando dados atualizados*/
			return userRepository.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}
    /*metodo que realiza as atualizações */
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}

}
