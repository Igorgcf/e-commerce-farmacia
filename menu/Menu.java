package com.igor.farmacia.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.igor.farmacia.controller.ProdutoController;
import com.igor.farmacia.model.Cosmetico;
import com.igor.farmacia.model.Medicamento;
import com.igor.farmacia.util.Cores;



public class Menu {

	public static void main(String[] args) {
		
		String nome;
		int tipo;
		float preco;
		String generico;
		String fragancia;
		int opcao;
		int numero;
		
		Scanner leia =  new Scanner(System.in);

		ProdutoController produtoController = new ProdutoController();
		while(true) {
			System.out.println(Cores.TEXT_RED + Cores.ANSI_WHITE_BACKGROUND 
					+     "******************************************************");
		System.out.println("                                                     ");
		System.out.println("               Farmacia Familia 69                   ");
		System.out.println("                                                     ");
		System.out.println("*****************************************************");
		System.out.println("                                                     ");
		System.out.println("            1 - Criar produto                        ");
		System.out.println("            2 - Listar todos os produtos             ");
		System.out.println("            3 - Buscar produto por Número            ");
		System.out.println("            4 - Atualizar Dados do produto           ");
		System.out.println("            5 - Deletar produto                      ");
		System.out.println("            6 - Sair                                 ");
		System.out.println("                                                     ");
		System.out.println("*****************************************************");
		System.out.println("            Entre com a opção desejada:              ");
		System.out.println("                                                     ");
		System.out.println(" ****************************************************" + Cores.TEXT_RESET);
		
		try {
			opcao = leia.nextInt();
		}catch(InputMismatchException e){
			System.out.println("\nDigite valores inteiros!");
			leia.nextLine();
			opcao=0;
	}
		
		if (opcao == 6) {
			System.out.println("Programa finalizado!!!");
			leia.close();
			System.exit(0);
		}
		
		switch(opcao) {
		case 1 :
			System.out.println("\nCriar produto");
			
			do {
			System.out.println("\nEntre o tipo do produto: 1- medicamento / 2- cosmético ");
			tipo = leia.nextInt();
			}while(tipo < 1 && tipo > 2);
			
			switch(tipo) {
			case 1 -> {
			
			System.out.println("\nEntre com o nome do medicamento: ");
			leia.skip("\\R");
			nome = leia.nextLine();
			
			System.out.println("\nEntre com o preço do medicamento: ");
			preco = leia.nextFloat();
			
			System.out.println("\nO medicamento é genérico? ");
			generico = leia.next();
			
			produtoController.criarProduto(new Medicamento(produtoController.gerarContador(), tipo, nome, preco, generico));;
			}
			
		case 2 -> {
			System.out.println("\nDigite o nome do cosmético: ");
			leia.skip("\\R");
			nome = leia.nextLine();
			
			System.out.println("\nDigite o preço do cosmético: ");
			
			preco = leia.nextFloat();
			
			System.out.println("\nDigite a fragância do cosmético: ");
			leia.skip("\\R");
			fragancia = leia.nextLine();
			
			produtoController.criarProduto(new Cosmetico(produtoController.gerarContador(), tipo, nome, preco, fragancia));
		}
			}
			break;
		case 2:
			System.out.println("Listando todos os produtos:");
			produtoController.listarTodosOsProdutos();
			
			break;
			
		case 3: 
			System.out.println("Buscar produto por Id: ");
			numero = leia.nextInt();
			
			produtoController.consultarProdutoPorId(numero);
			break;
		case 4: 
			System.out.println("Atualizar dados do produto! ");
			
			System.out.println("\nDigite o número do produto:");
			numero = leia.nextInt();
			
			var buscaProduto = produtoController.buscarNaCollection(numero);
			
			if(buscaProduto != null) {

				tipo = buscaProduto.getTipo();
				
				do {
				System.out.println("Digite o tipo do produto: 1-medicamento / 2-cosmético");
				tipo = leia.nextInt();
				}while(tipo < 1 && tipo > 2);
				
				switch(tipo) {
				case 1 -> {
					
				System.out.println("\nDigite o nome do medicamento: ");
				nome = leia.next();
				
				System.out.println("\nDigite o preço do medicamento: ");
				preco = leia.nextFloat();
				
				System.out.println("\nO medicamento é genérico ?");
				generico = leia.next();
				
				produtoController.atualizarProduto(new Medicamento(numero, tipo, nome, preco, generico));
				}
				
				case 2 -> {
					System.out.println("\nDigite o nome do cosmético: ");
					leia.skip("\\R");
					nome = leia.nextLine();
					
					System.out.println("\nDigite o preço do cosmético: ");
					preco = leia.nextFloat();
					
					System.out.println("\nDigite a fragância do cosmético: ");
					leia.skip("\\R");
					fragancia = leia.nextLine();
					produtoController.atualizarProduto(new Cosmetico(numero, tipo, nome, preco, fragancia));
				}
			}
			}
			break;
			
		case 5: 
			System.out.println("Deletar produto!");
			
			System.out.println("\nDigite o número do produto: ");
			numero = leia.nextInt();
			
			 buscaProduto = produtoController.buscarNaCollection(numero);
			 
			 if(buscaProduto != null) {
				 produtoController.deletarProduto(numero);
			 }
			
		}
		}
	}
		}
		
	

	
		

	

