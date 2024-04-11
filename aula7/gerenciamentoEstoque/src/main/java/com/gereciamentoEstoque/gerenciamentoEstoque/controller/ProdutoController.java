package com.gereciamentoEstoque.gerenciamentoEstoque.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gereciamentoEstoque.gerenciamentoEstoque.model.Produto;
import com.gereciamentoEstoque.gerenciamentoEstoque.repository.ProdutoRepository;

@Controller
public class ProdutoController {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtoForm")
	public String produtoFormularioGet() {
		return "cadastroProduto";
	}
	
	@PostMapping("/produtoForm")
	public String produtoFormularioPost(Produto produto) {
		produtoRepository.save(produto);
		
		return "cadastroProduto";
		
	}
	
	@GetMapping("/listaProdutos")
	public ModelAndView listarProdutos() {
		ModelAndView produtoMV = new ModelAndView("listaProdutos");
		List<Produto> listaProdutos = (List<Produto>) produtoRepository.findAll();

		
		produtoMV.addObject("produtos", listaProdutos);
		
		return produtoMV;
		
	}
	
	
	@RequestMapping("/deletar")
	public String deletarProduto(long id) {
		Produto produto = produtoRepository.findById(id);
		produtoRepository.delete(produto);
		return"redirect:/listaProdutos";
		
	}
	
	
	@RequestMapping("/editaProduto")
	public ModelAndView editarProduto(long id) {
		
		Produto produtoEncontrado = produtoRepository.findById(id);
		
		ModelAndView modelAndViewProduto = new ModelAndView("editaProduto");
		
		modelAndViewProduto.addObject("produto", produtoEncontrado);
		
		return modelAndViewProduto;
		
	}
	
	@PostMapping("/editaProduto")
	public String editarProdutoPost(Produto produto) {
		
		produtoRepository.save(produto);
		
		
		return "redirect:/listaProdutos";
	}
	
	
	
}
