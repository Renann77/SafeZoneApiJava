package br.com.fiap.safezoneapi.repository;

import br.com.fiap.safezoneapi.model.LeituraSensor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeituraSensorRepository extends JpaRepository<LeituraSensor, Long> {
    List<LeituraSensor> findBySensorId(Long sensorId); // Leituras por sensor
}
