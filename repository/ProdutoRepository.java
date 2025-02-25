package com.igor.farmacia.repository;

import com.igor.farmacia.model.Produto;

public interface ProdutoRepository {

	public void criarProduto(Produto produto);
	public void listarTodosOsProdutos();
	public void consultarProdutoPorId(int numero);
	public void atualizarProduto(Produto produto);
	public void deletarProduto(int numero);
}
