package br.com.fiap.safezoneapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.safezoneapi.model.Sensor;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
    List<Sensor> findByRegiaoId(Long regiaoId);
}
