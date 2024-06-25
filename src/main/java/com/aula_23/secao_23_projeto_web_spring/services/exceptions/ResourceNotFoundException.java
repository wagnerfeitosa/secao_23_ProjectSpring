package com.aula_23.secao_23_projeto_web_spring.services.exceptions;

/*Excecao personalidada para que retorne um tratamento de excecao adecado
 * para as requisições HTTP*/
public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	/*Construtor recebe o id do objeto que tentou encontrar */
	public ResourceNotFoundException(Object id) {
		/*caso não encontra o objeto lansará uma mensagem de excecao*/
		super("Recurso nao encontrado. id" + id);
	}

}
