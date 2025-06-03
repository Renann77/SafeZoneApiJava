package br.com.fiap.safezoneapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.safezoneapi.model.Sensor;
import br.com.fiap.safezoneapi.service.SensorService;

@RestController
@RequestMapping("/api/sensores")
public class SensorController {

    private final SensorService sensorService;

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @GetMapping
    public List<Sensor> listar() {
        return sensorService.findAll();
    }

    @GetMapping("/regiao/{regiaoId}")
    public List<Sensor> listarPorRegiao(@PathVariable Long regiaoId) {
        return sensorService.findByRegiaoId(regiaoId);
    }

    @PostMapping
    public ResponseEntity<Sensor> cadastrar(@RequestBody Sensor sensor) {
        return ResponseEntity.ok(sensorService.save(sensor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (!sensorService.existsById(id))
            return ResponseEntity.notFound().build();
        sensorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sensor> atualizar(@PathVariable Long id, @RequestBody Sensor sensor) {
        return ResponseEntity.ok(sensorService.update(id, sensor));
    }
}
