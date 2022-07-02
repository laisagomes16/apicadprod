package com.api.produtor.dtos;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class ProdutorDto {

    @NotBlank(message = "Nome obrigatorio!")
    private String nome;

    @NotNull(message = "Data Inicial obrigatorio!")
    private LocalDateTime dataInicial;

    @NotNull(message = "Data Final obrigatorio!")
    private LocalDateTime dataFinal;

    @NotBlank(message = "CNPJ obrigatorio!")
    private String cnpj;

    private String observacoes;

    @NotNull(message = "Propriedade obrigatoria!")
    private PropriedadeDto infosPropriedade;

    @NotNull(message = "Laboratorio obrigatoria!")
    private LaboratorioDto laboratorio;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDateTime dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalDateTime getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDateTime dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public PropriedadeDto getInfosPropriedade() {
        return infosPropriedade;
    }

    public void setInfosPropriedade(PropriedadeDto infosPropriedade) {
        this.infosPropriedade = infosPropriedade;
    }

    public LaboratorioDto getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(LaboratorioDto laboratorio) {
        this.laboratorio = laboratorio;
    }
}
