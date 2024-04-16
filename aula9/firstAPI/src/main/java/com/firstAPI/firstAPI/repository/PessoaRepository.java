package com.firstAPI.firstAPI.repository;

import com.firstAPI.firstAPI.model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.firstAPI.firstAPI.model.PessoaModel;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel, Long>{



}
