package br.com.fiap.safezoneapi.repository;

import br.com.fiap.safezoneapi.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
    List<Sensor> findByRegiaoId(Long regiaoId); // Ex: pegar sensores de uma região
}
