package br.com.fiap.safezoneapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.safezoneapi.model.Regiao;
import br.com.fiap.safezoneapi.repository.RegiaoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class RegiaoServiceImpl implements RegiaoService {

    @Autowired
    private RegiaoRepository regiaoRepository;

    @Override
    public List<Regiao> findAll() {
        return regiaoRepository.findAll();
    }

    @Override
    public Optional<Regiao> findById(Long id) {
        return regiaoRepository.findById(id);
    }

    @Override
    public Regiao save(Regiao regiao) {
        return regiaoRepository.save(regiao);
    }

    @Override
    public Regiao update(Long id, Regiao regiao) {
        Regiao existente = regiaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Região não encontrada com ID: " + id));

        existente.setNome(regiao.getNome());

        return regiaoRepository.save(existente);
    }

    @Override
    public void delete(Long id) {
        regiaoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return regiaoRepository.existsById(id);
    }
}
