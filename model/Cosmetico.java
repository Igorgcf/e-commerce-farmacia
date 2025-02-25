package com.igor.farmacia.model;

public class Cosmetico extends Produto{

	String fragancia;
	
	public Cosmetico(int id, int tipo, String nome, float preco, String fragancia) {
		super(id, tipo, nome, preco);
		this.fragancia = fragancia;
		
	}

	public String getFragancia() {
		return fragancia;
	}

	public void setFragancia(String fragancia) {
		this.fragancia = fragancia;
	}
	
	public void visualisar() {
		super.visualisar();
		System.out.println("\nA fragancia do cosmético é: " + this.fragancia);
	}
}
