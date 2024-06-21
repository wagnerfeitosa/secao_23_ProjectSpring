package com.aula_23.secao_23_projeto_web_spring.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aula_23.secao_23_projeto_web_spring.entities.User;
import com.aula_23.secao_23_projeto_web_spring.services.UserService;

/*@RestController trata-se de um controlador Rest*
 * Obs:Controller depende de uma camada de serviços
 * @RestMapping trata-se de uma Anotação que mapeia uma url para o recurso
 * value = "/users"*/

@RestController
@RequestMapping(value = "/users")
public class UseResource {
	/*@Autowired é para que o spring gerer a injeção de dependencia
	Obs:para que o spring possa gerar a injeção de dependencia para objeto
	UserService é necessario registrar o objeto UserService 
	para tal basta que na classe UserService inserir Anotação @Service*/
	
	@Autowired	
	private UserService service;
	
	/*@GetMapping Indica que esse metodo responde requisição http tipo Get
	 * ResponseEntity<T> é um tipo especifico do Spring para retornar respostas
	 * de requisições Web*/
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();	
		//return ResponseEntity.ok() -> retorna com sucesso.body(user);->corpo do objeto
		return ResponseEntity.ok().body(list);
	}
	/*@GetMapping recebe requisições com a url "/{id}"
	 * @PathVariable faz com que o que for digitado na url {id} seja recebido nos parametro
	 * do metodo findById*/
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User>  findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	/*@RequestBody Serve para dizer que irá receber uma requisição no formato Json
	 * e será serializado para objeto User a parti do metodo post do HTTP*/
	@PostMapping        
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		/*OBS:Quando inserir um recurso é mais adequado retornar codigo de resposta 201 
		 * que significa que foi criado um novo recurso para isso ->
		 * return ResponseEntity.created(uri) recebe um objeto do tipo URI
		 * que retorna endereco do novo recurso inserido 
		 * Objeto URI cria um endereco para retornar 
		 * metodo path("/{id}") indica a url será digitadono navegador ursers/id
		 * metodo buildAndExpand(obj.getId) recebe o id que foi inserido no caso id do obj inserido
		 * metodo toUri() converte para objeto tipo URI*/
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
		
	}

}
