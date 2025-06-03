package br.com.fiap.safezoneapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.safezoneapi.model.LeituraSensor;
import br.com.fiap.safezoneapi.repository.LeituraSensorRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class LeituraSensorServiceImpl implements LeituraSensorService {

    @Autowired
    private LeituraSensorRepository leituraRepository;

    @Override
    public List<LeituraSensor> findAll() {
        return leituraRepository.findAll();
    }

    @Override
    public Optional<LeituraSensor> findById(Long id) {
        return leituraRepository.findById(id);
    }

    @Override
    public LeituraSensor save(LeituraSensor leitura) {
        return leituraRepository.save(leitura);
    }

    @Override
    public LeituraSensor update(Long id, LeituraSensor leitura) {
        LeituraSensor existente = leituraRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Leitura não encontrada com ID: " + id));

        existente.setValor(leitura.getValor());
        existente.setDataHora(leitura.getDataHora());
        existente.setSensor(leitura.getSensor());

        return leituraRepository.save(existente);
    }

    @Override
    public void delete(Long id) {
        leituraRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return leituraRepository.existsById(id);
    }
}
