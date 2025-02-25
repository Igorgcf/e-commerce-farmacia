package com.igor.farmacia.controller;

import java.util.ArrayList;

import com.igor.farmacia.model.Produto;
import com.igor.farmacia.repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository {

	ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	int numero =0;
	@Override
	public void criarProduto(Produto produto) {
		listaProdutos.add(produto);
		System.out.println("\nO produto " + produto.getId() + " foi criado com sucesso!");
	}

	@Override
	public void listarTodosOsProdutos() {
		for(var listar : listaProdutos) {
			listar.visualisar();
			
			
			
		}
	
	}

	@Override
	public void consultarProdutoPorId(int numero) {
	
		var lista = buscarNaCollection( numero);
		
		if (lista != null) {
			lista.visualisar();
		}else {
			System.out.println("\nO produto número: " + numero + " não foi encontrado!");
		}
		
	}

	@Override
	public void atualizarProduto(Produto produto) {
		
		var buscaProduto = buscarNaCollection(produto.getId());
		
		if(buscaProduto != null) {
			listaProdutos.set(listaProdutos.indexOf(buscaProduto), produto);
			System.out.println("\nO produto número " + produto.getId() + " foi atualizado com sucesso");
		}else {
			System.out.println("\nO produto número " + produto.getId() + " não foi encontrado!");
		}
		
	}

	@Override
	public void deletarProduto(int numero) {
		var lista = buscarNaCollection(numero);
		
		if(lista != null) {
			if (listaProdutos.remove(lista) == true){
				System.out.println("\nO produto número " + lista.getId() + " foi deletado com sucesso!");
			}else {
				System.out.println("\nO produto número " + lista.getId() + " não foi encontrado!");
			}
		}
		
	}

	public Produto buscarNaCollection (int numero) {
		for (var lista : listaProdutos) {
			if(lista.getId() == numero) {
				return lista;
			}
		}
		return null;
	}
	
	public int gerarContador() {
		return ++ numero;
	}
	
}
