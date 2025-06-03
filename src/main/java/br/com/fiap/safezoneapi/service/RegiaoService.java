package br.com.fiap.safezoneapi.service;

import java.util.List;
import java.util.Optional;

import br.com.fiap.safezoneapi.model.Regiao;

public interface RegiaoService {

    List<Regiao> findAll();

    Optional<Regiao> findById(Long id);

    Regiao save(Regiao regiao);

    Regiao update(Long id, Regiao regiao);

    void delete(Long id);

    boolean existsById(Long id);
}
