package com.impacta.escola.cadastroTime.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.impacta.escola.cadastroTime.model.Jogador;

@Repository
public interface JogadorRepository extends CrudRepository<Jogador, String> {

}