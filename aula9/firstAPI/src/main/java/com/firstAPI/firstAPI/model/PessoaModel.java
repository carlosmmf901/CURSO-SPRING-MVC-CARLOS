package com.firstAPI.firstAPI.model;

import jakarta.persistence.*;

import java.io.Serializable;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class PessoaModel {
    private String meuTexto;
    private String email;
    private String nome;
    private String cpf;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
