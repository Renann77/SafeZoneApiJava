package br.com.fiap.safezoneapi.controller;

import br.com.fiap.safezoneapi.model.LeituraSensor;
import br.com.fiap.safezoneapi.repository.LeituraSensorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/leituras")
public class LeituraSensorController {

    private final LeituraSensorRepository repository;

    public LeituraSensorController(LeituraSensorRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<LeituraSensor> listar() {
        return repository.findAll();
    }

    @GetMapping("/sensor/{sensorId}")
    public List<LeituraSensor> porSensor(@PathVariable Long sensorId) {
        return repository.findBySensorId(sensorId);
    }

    @PostMapping
    public ResponseEntity<LeituraSensor> cadastrar(@RequestBody LeituraSensor leitura) {
        leitura.setDataHora(LocalDateTime.now());
        return ResponseEntity.ok(repository.save(leitura));
    }
}
