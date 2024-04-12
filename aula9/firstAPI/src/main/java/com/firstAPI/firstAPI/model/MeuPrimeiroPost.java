package com.firstAPI.firstAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class MeuPrimeiroPost implements Serializable {
    private String meuTexto;
    private String email;
    private String nome;
    private int cpf;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public String getMeuTexto() {
        return meuTexto;

    }

    public void setMeuTexto(String meuTexto) {
        this.meuTexto = meuTexto;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
}
