package com.api.produtor.dtos;

import javax.validation.constraints.NotBlank;

public class PropriedadeDto {
    @NotBlank
    private  Integer id;

    @NotBlank
    private String nome;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
