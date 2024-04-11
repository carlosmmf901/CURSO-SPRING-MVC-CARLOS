package com.gereciamentoEstoque.gerenciamentoEstoque.service;

import java.util.List;

import com.gereciamentoEstoque.gerenciamentoEstoque.model.*;

public class SituacaoEstoque {
	
	public double calcularValorTotalEstoque(List<Produto> produtos) {
		double total = 0;
		
		for (Produto produto : produtos) {
			total += produto.getPrecoUnitario() * produto.getQuantidadeEstoque();	
			
		}
		return total;  
	}
	
	public Produto encontrarProdutoMaisCaro(List<Produto> produtos) {
		Produto maisCaro = null;
		double maiorPreco = Double.MIN_VALUE;
		
		for (Produto produto : produtos) {
			if (produto.getPrecoUnitario() > maiorPreco) {
				maiorPreco = produto.getPrecoUnitario();
				maisCaro = produto;
			}
		}
		
		return maisCaro;
	}
	
	public Produto encontrarProdutoMenosCaro(List<Produto> produtos) {
		Produto menosCaro = null;
		double menorPreco = Double.MAX_VALUE;
		
		for (Produto produto : produtos) {
			if (produto.getPrecoUnitario() < menorPreco) {
				menorPreco = produto.getPrecoUnitario();
				menosCaro = produto;
			}
		}
		return menosCaro;
	}
	
	
}
