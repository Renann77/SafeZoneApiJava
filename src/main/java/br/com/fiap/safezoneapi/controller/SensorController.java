package br.com.fiap.safezoneapi.controller;

import br.com.fiap.safezoneapi.model.Sensor;
import br.com.fiap.safezoneapi.repository.SensorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensores")
public class SensorController {

    private final SensorRepository repository;

    public SensorController(SensorRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Sensor> listar() {
        return repository.findAll();
    }

    @GetMapping("/regiao/{regiaoId}")
    public List<Sensor> listarPorRegiao(@PathVariable Long regiaoId) {
        return repository.findByRegiaoId(regiaoId);
    }

    @PostMapping
    public ResponseEntity<Sensor> cadastrar(@RequestBody Sensor sensor) {
        return ResponseEntity.ok(repository.save(sensor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
