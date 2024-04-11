package com.gereciamentoEstoque.gerenciamentoEstoque.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gereciamentoEstoque.gerenciamentoEstoque.model.Produto;


@Repository
public interface ProdutoRepository extends CrudRepository <Produto, String> {
	

	//Para Encontrar o animal pelo ID
	Produto findById(long id);
	
	
	
}