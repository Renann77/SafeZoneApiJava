package br.com.fiap.safezoneapi.controller;

import br.com.fiap.safezoneapi.model.Regiao;
import br.com.fiap.safezoneapi.repository.RegiaoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/regioes")
public class RegiaoController {

    private final RegiaoRepository repository;

    public RegiaoController(RegiaoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Regiao> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Regiao> buscar(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Regiao> cadastrar(@RequestBody Regiao regiao) {
        return ResponseEntity.ok(repository.save(regiao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Regiao> atualizar(@PathVariable Long id, @RequestBody Regiao novaRegiao) {
        return repository.findById(id).map(r -> {
            r.setNome(novaRegiao.getNome());
            r.setCidade(novaRegiao.getCidade());
            r.setRiscoAtual(novaRegiao.getRiscoAtual());
            return ResponseEntity.ok(repository.save(r));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
