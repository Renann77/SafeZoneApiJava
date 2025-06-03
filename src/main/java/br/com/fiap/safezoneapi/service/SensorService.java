package br.com.fiap.safezoneapi.service;

import java.util.List;
import java.util.Optional;

import br.com.fiap.safezoneapi.model.Sensor;

public interface SensorService {

    List<Sensor> findAll();

    Optional<Sensor> findById(Long id);

    Sensor save(Sensor sensor);

    Sensor update(Long id, Sensor sensor);

    void delete(Long id);

    List<Sensor> findByRegiaoId(Long regiaoId);

    boolean existsById(Long id);
}
