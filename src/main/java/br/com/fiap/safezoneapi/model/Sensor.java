package br.com.fiap.safezoneapi.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_SENSOR")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TIPO", nullable = false)
    private String tipo;

    @Column(name = "LOCALIZACAO")
    private String localizacao;

    @ManyToOne
    @JoinColumn(name = "REGIAO_ID", nullable = false)
    private Regiao regiao;

    @OneToMany(mappedBy = "sensor", cascade = CascadeType.ALL)
    private List<LeituraSensor> leituras;

    public Sensor() {}

    public Sensor(Long id, String tipo, String localizacao, Regiao regiao, List<LeituraSensor> leituras) {
        this.id = id;
        this.tipo = tipo;
        this.localizacao = localizacao;
        this.regiao = regiao;
        this.leituras = leituras;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }

    public Regiao getRegiao() { return regiao; }
    public void setRegiao(Regiao regiao) { this.regiao = regiao; }

    public List<LeituraSensor> getLeituras() { return leituras; }
    public void setLeituras(List<LeituraSensor> leituras) { this.leituras = leituras; }
}
