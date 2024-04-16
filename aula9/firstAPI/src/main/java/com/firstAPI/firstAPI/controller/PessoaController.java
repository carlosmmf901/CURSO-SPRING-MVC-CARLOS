package com.firstAPI.firstAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.firstAPI.firstAPI.repository.PessoaRepository;
import com.firstAPI.firstAPI.model.PessoaModel;
import com.firstAPI.firstAPI.exception.ResourceNotFoundException;



@RestController
public class PessoaController {

    @Autowired
    PessoaRepository pessoaRepository;

    @GetMapping("/meuPrimeiroGet") // Isso é um endpoint
    public String meuPrimeiroGet(){

        return "Esse é o seu primeiro get na API";
    }

    @PostMapping("/user")
    public String criarUsuario(@RequestBody PessoaModel pessoaModel) {
        pessoaRepository.save(pessoaModel);
        return "User created successfully";
    }

    @GetMapping("/listaUsuarios")
    public Iterable<PessoaModel> buscaUsuarios() {
        return pessoaRepository.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/meuPrimeiroPostRota") // Isso é um endpoint
    public String meuPrimeiroPost(@RequestBody PessoaModel pessoaModel){

        pessoaRepository.save(pessoaModel);
        return "O texto enviado foi:" + pessoaModel.getMeuTexto();

    }

    @GetMapping("/PessoaRota/{id}")
    public ResponseEntity<PessoaModel> buscarUsuarioPeloID(@PathVariable(value = "id") long pessoaId)
            throws ResourceNotFoundException {
        PessoaModel pessoaModel =
                pessoaRepository
                        .findById(pessoaId) // busca a pessoa
                        //Caso não encontre, ele entra na exeption
                        .orElseThrow(() -> new ResourceNotFoundException("Não existe pessoa com o ID: " + pessoaId));

        return ResponseEntity.ok().body(pessoaModel);
    }

    @DeleteMapping("/PessoaRota/{id}")
    public String deletarPessoa(@PathVariable(value = "id") long pessoaId)
            throws ResourceNotFoundException {
        PessoaModel pessoaModel =
                pessoaRepository
                        .findById(pessoaId) // busca a pessoa
                        //Caso não encontre, ele entra na exeption
                        .orElseThrow(() -> new ResourceNotFoundException("Não existe pessoa com o ID: " + pessoaId));
        pessoaRepository.delete(pessoaModel);
        return pessoaModel.getNome() + "Deletado";
    }

    @PutMapping("/PessoaRota/")
    public String alterarPessoa(@RequestBody PessoaModel pessoaModelRequest)
            throws ResourceNotFoundException {
        PessoaModel pessoaModel =
                pessoaRepository
                        .findById(pessoaModelRequest.getId()) // busca a pessoa
                        //Caso não encontre, ele entra na exeption
                        .orElseThrow(() -> new ResourceNotFoundException("Não existe pessoa com o ID: " + pessoaModelRequest.getId()));

        //pessoaModelRequest.setId(5000);
        pessoaRepository.save(pessoaModelRequest);
        return pessoaModelRequest.getNome() + " Foi Alterado";
    }


}
