package com.aula_23.secao_23_projeto_web_spring.enums;

public enum OrderStatus {
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	//Construtor e privado
	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	/*Metodo statico não precisa instanciar 
	 * Verifica se há OrderStatus com o numero informado*/
	public static OrderStatus valueOfObj(int code) {
		for(OrderStatus value : OrderStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
	public static void main(String[] args) {
		System.out.println(OrderStatus.valueOfObj(2));
	}

}
