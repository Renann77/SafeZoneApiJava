package br.com.fiap.safezoneapi.service;

import java.util.List;
import java.util.Optional;

import br.com.fiap.safezoneapi.model.Alerta;

public interface AlertaService {

    List<Alerta> findAll();

    Optional<Alerta> findById(Long id);

    Alerta save(Alerta alerta);

    Alerta update(Long id, Alerta alerta);

    void delete(Long id);

    boolean existsById(Long id);
}
