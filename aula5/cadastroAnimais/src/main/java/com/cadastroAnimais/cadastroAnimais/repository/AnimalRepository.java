package com.cadastroAnimais.cadastroAnimais.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cadastroAnimais.cadastroAnimais.model.Animal;


@Repository
public interface AnimalRepository extends CrudRepository <Animal, String> {
	

	//Para Encontrar o animal pelo ID
	Animal findById(long id);
	
	
	
}
