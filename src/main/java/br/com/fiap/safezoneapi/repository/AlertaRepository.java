package br.com.fiap.safezoneapi.repository;

import br.com.fiap.safezoneapi.model.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlertaRepository extends JpaRepository<Alerta, Long> {
    List<Alerta> findByRegiaoId(Long regiaoId);
    List<Alerta> findByAtivoTrue(); // Para buscar apenas alertas ativos
}
