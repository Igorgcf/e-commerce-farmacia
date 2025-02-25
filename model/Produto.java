package com.igor.farmacia.model;

public abstract class Produto {
	
	int id;
	int tipo;
	String nome;
	float preco;
	
	public Produto(int id, int tipo, String nome, float preco) {
		this.id = id;
		this.tipo = tipo;
		this.nome = nome;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public void visualisar() {
		
		String tipo = "";
		
		switch(this.tipo) {
		case 1:
		tipo = "Medicamento";
		break;
		
		case 2:
			tipo = "Cosmético";
			break;
		
		}
		System.out.println("************************************");
		System.out.println("Dados do produto:");
		System.out.println("************************************");
		System.out.println("\nNúmero do produto: " + this.id);
		System.out.println("\nTipo do produto: " + tipo);
		System.out.println("\nNome do produto: " + this.nome);
		System.out.println("\nPreço do produto: " + this.preco + " R$");
	}

	
	}

