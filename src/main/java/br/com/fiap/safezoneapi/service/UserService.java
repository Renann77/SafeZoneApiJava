package br.com.fiap.safezoneapi.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.fiap.safezoneapi.model.User;

public interface UserService {
    User save(User user);

    Optional<User> findByUsername(String username);

    Optional<User> findById(Long id);

    Page<User> findAll(Pageable pageable);

    Page<User> findByUsernameContaining(String username, Pageable pageable);

    void deleteById(Long id);
}
