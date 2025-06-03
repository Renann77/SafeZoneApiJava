package br.com.fiap.safezoneapi.service;

import java.util.List;
import java.util.Optional;

import br.com.fiap.safezoneapi.model.LeituraSensor;

public interface LeituraSensorService {

    List<LeituraSensor> findAll();

    Optional<LeituraSensor> findById(Long id);

    LeituraSensor save(LeituraSensor leitura);

    LeituraSensor update(Long id, LeituraSensor leitura);

    void delete(Long id);

    boolean existsById(Long id);
}
