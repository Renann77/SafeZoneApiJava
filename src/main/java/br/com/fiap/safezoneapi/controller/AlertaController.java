package br.com.fiap.safezoneapi.controller;

import br.com.fiap.safezoneapi.model.Alerta;
import br.com.fiap.safezoneapi.repository.AlertaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alertas")
public class AlertaController {

    private final AlertaRepository repository;

    public AlertaController(AlertaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Alerta> listarTodos() {
        return repository.findAll();
    }

    @GetMapping("/ativos")
    public List<Alerta> listarAtivos() {
        return repository.findByAtivoTrue();
    }

    @GetMapping("/regiao/{regiaoId}")
    public List<Alerta> porRegiao(@PathVariable Long regiaoId) {
        return repository.findByRegiaoId(regiaoId);
    }

    @PostMapping
    public ResponseEntity<Alerta> cadastrar(@RequestBody Alerta alerta) {
        return ResponseEntity.ok(repository.save(alerta));
    }

    @PutMapping("/{id}/resolver")
    public ResponseEntity<Alerta> resolver(@PathVariable Long id) {
        return repository.findById(id).map(alerta -> {
            alerta.setAtivo(false);
            return ResponseEntity.ok(repository.save(alerta));
        }).orElse(ResponseEntity.notFound().build());
    }
}
