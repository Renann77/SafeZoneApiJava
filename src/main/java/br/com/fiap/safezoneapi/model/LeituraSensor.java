package br.com.fiap.safezoneapi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_LEITURA_SENSOR")
public class LeituraSensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DATA_HORA")
    private LocalDateTime dataHora;

    @Column(name = "VALOR", nullable = false)
    private Double valor;

    @ManyToOne
    @JoinColumn(name = "SENSOR_ID", nullable = false)
    private Sensor sensor;

    public LeituraSensor() {}

    public LeituraSensor(Long id, LocalDateTime dataHora, Double valor, Sensor sensor) {
        this.id = id;
        this.dataHora = dataHora;
        this.valor = valor;
        this.sensor = sensor;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }

    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }

    public Sensor getSensor() { return sensor; }
    public void setSensor(Sensor sensor) { this.sensor = sensor; }
}
