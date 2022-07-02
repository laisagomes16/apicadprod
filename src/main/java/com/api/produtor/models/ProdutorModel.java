package com.api.produtor.models;

import com.api.produtor.services.LocalDateAttributeConverter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;



@Entity
@Table(name = "produtor")
public class ProdutorModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 20)
    private String nome;

    @Convert(converter = LocalDateAttributeConverter.class)
    @Column(nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime dataInicial;

    @Convert(converter = LocalDateAttributeConverter.class)
    @Column(nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime dataFinal;

    @Column(nullable = false, length = 18)
    private String cnpj;

    @Column(nullable = false, length = 100)
    private String observacoes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "laboratorio_id", nullable = false)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private LaboratorioModel laboratorio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "propriedades_id", nullable = false)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private PropriedadeModel infosPropriedade;

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

    public LaboratorioModel getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(LaboratorioModel laboratorio) {
        this.laboratorio = laboratorio;
    }

    public PropriedadeModel getInfosPropriedade() {
        return infosPropriedade;
    }

    public void setInfosPropriedade(PropriedadeModel infosPropriedade) {
        this.infosPropriedade = infosPropriedade;
    }
}
