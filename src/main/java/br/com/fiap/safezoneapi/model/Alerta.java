package br.com.fiap.safezoneapi.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ALERTA")
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TIPO", nullable = false)
    private String tipo;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "ATIVO")
    private Boolean ativo;

    @ManyToOne
    @JoinColumn(name = "REGIAO_ID", nullable = false)
    private Regiao regiao;

    @ManyToOne
    @JoinColumn(name = "SENSOR_ID")
    private Sensor sensor;

    @Column(name = "DATA_ALERTA")
    private LocalDateTime data;

    public Alerta() {
    }

    public Alerta(Long id, String tipo, String descricao, Boolean ativo, Regiao regiao, Sensor sensor,
            LocalDateTime data) {
        this.id = id;
        this.tipo = tipo;
        this.descricao = descricao;
        this.ativo = ativo;
        this.regiao = regiao;
        this.sensor = sensor;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
