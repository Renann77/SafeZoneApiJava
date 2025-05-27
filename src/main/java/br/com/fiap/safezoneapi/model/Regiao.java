package br.com.fiap.safezoneapi.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_REGIAO")
public class Regiao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "CIDADE", nullable = false)
    private String cidade;

    @Column(name = "RISCO_ATUAL")
    private Double riscoAtual;

    @OneToMany(mappedBy = "regiao", cascade = CascadeType.ALL)
    private List<Sensor> sensores;

    public Regiao() {}

    public Regiao(Long id, String nome, String cidade, Double riscoAtual, List<Sensor> sensores) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.riscoAtual = riscoAtual;
        this.sensores = sensores;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public Double getRiscoAtual() { return riscoAtual; }
    public void setRiscoAtual(Double riscoAtual) { this.riscoAtual = riscoAtual; }

    public List<Sensor> getSensores() { return sensores; }
    public void setSensores(List<Sensor> sensores) { this.sensores = sensores; }
}
