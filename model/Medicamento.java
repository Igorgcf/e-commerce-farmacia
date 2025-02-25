package com.igor.farmacia.model;

public class Medicamento extends Produto{

	String generico;
	
	public Medicamento(int id, int tipo, String nome, float preco, String generico) {
		super(id, tipo, nome, preco);
		this.generico = generico;
	}


	public String getGenerico() {
		return generico;
	}


	public void setGenerico(String generico) {
		this.generico = generico;
	}


	public void visualisar() {
		super.visualisar();
			System.out.println("\nMedicamento genérico? ");
			System.out.println("- " + this.generico);
		}
	} 

