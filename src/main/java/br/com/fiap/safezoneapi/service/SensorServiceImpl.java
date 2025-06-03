package br.com.fiap.safezoneapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.safezoneapi.model.Sensor;
import br.com.fiap.safezoneapi.repository.SensorRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class SensorServiceImpl implements SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    @Override
    public List<Sensor> findAll() {
        return sensorRepository.findAll();
    }

    @Override
    public Optional<Sensor> findById(Long id) {
        return sensorRepository.findById(id);
    }

    @Override
    public Sensor save(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    @Override
    public Sensor update(Long id, Sensor sensor) {
        Sensor existente = sensorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sensor não encontrado com ID: " + id));

        existente.setTipo(sensor.getTipo());
        existente.setLocalizacao(sensor.getLocalizacao());
        existente.setRegiao(sensor.getRegiao());

        return sensorRepository.save(existente);
    }

    @Override
    public void delete(Long id) {
        sensorRepository.deleteById(id);
    }

    @Override
    public List<Sensor> findByRegiaoId(Long regiaoId) {
        return sensorRepository.findByRegiaoId(regiaoId);
    }

    @Override
    public boolean existsById(Long id) {
        return sensorRepository.existsById(id);
    }
}
