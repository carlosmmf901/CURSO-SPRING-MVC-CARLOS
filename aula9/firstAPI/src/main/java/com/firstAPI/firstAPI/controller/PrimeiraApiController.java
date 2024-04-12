package com.firstAPI.firstAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.firstAPI.firstAPI.repository.MeuPrimeiroTextoRepository;
import com.firstAPI.firstAPI.model.MeuPrimeiroPost;


@RestController
public class  PrimeiraApiController {

    @Autowired
    MeuPrimeiroTextoRepository meuPrimeiroTextoRepository;

    @GetMapping("/meuPrimeiroGet") // Isso é um endpoint
    public String meuPrimeiroGet(){

        return "Esse é o seu primeiro get na API";
    }

    @PostMapping("/user")
    public String criarUsuario(@RequestBody MeuPrimeiroPost meuPrimeiroPost) {
        meuPrimeiroTextoRepository.save(meuPrimeiroPost);
        return "User created successfully";
    }

    @GetMapping("/listaUsuarios")
    public Iterable<MeuPrimeiroPost> buscaUsuarios() {
        return meuPrimeiroTextoRepository.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/meuPrimeiroPostRota") // Isso é um endpoint
    public String meuPrimeiroPost(@RequestBody MeuPrimeiroPost meuPrimeiroPost){

        meuPrimeiroTextoRepository.save(meuPrimeiroPost);

        return "O texto enviado foi:" + meuPrimeiroPost.getMeuTexto();

    }



}
