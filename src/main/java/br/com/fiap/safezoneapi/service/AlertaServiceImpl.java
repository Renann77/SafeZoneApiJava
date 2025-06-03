package br.com.fiap.safezoneapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.safezoneapi.model.Alerta;
import br.com.fiap.safezoneapi.repository.AlertaRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class AlertaServiceImpl implements AlertaService {

    @Autowired
    private AlertaRepository alertaRepository;

    @Override
    public List<Alerta> findAll() {
        return alertaRepository.findAll();
    }

    @Override
    public Optional<Alerta> findById(Long id) {
        return alertaRepository.findById(id);
    }

    @Override
    public Alerta save(Alerta alerta) {
        return alertaRepository.save(alerta);
    }

    @Override
    public Alerta update(Long id, Alerta alerta) {
        Alerta existente = alertaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Alerta não encontrado com ID: " + id));

        existente.setDescricao(alerta.getDescricao());
        existente.setData(alerta.getData());
        existente.setSensor(alerta.getSensor());
        existente.setTipo(alerta.getTipo());
        existente.setAtivo(alerta.getAtivo());
        existente.setRegiao(alerta.getRegiao());

        return alertaRepository.save(existente);
    }

    @Override
    public void delete(Long id) {
        alertaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return alertaRepository.existsById(id);
    }
}
