package br.com.fiap.safezoneapi.controller;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.safezoneapi.model.User;
import br.com.fiap.safezoneapi.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Criar novo usuário
    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userService.save(user);
        return ResponseEntity.ok(savedUser);
    }

    // Listar usuários com paginação, ordenação e filtro opcional por username
    @GetMapping
    public ResponseEntity<Page<User>> getUsers(
            @RequestParam Optional<String> username,
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<Integer> size,
            @RequestParam Optional<String> sortBy,
            @RequestParam Optional<String> direction) {

        int currentPage = page.orElse(0);
        int pageSize = size.orElse(10);
        String sortField = sortBy.orElse("id");
        Sort.Direction sortDirection = direction.map(String::toUpperCase)
                .map(Sort.Direction::valueOf)
                .orElse(Sort.Direction.ASC);

        Pageable pageable = PageRequest.of(currentPage, pageSize, Sort.by(sortDirection, sortField));

        Page<User> usersPage;

        if (username.isPresent()) {
            usersPage = userService.findByUsernameContaining(username.get(), pageable);
        } else {
            usersPage = userService.findAll(pageable);
        }

        return ResponseEntity.ok(usersPage);
    }

    // Buscar usuário por id
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> userOpt = userService.findById(id);
        return userOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Atualizar usuário
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid @RequestBody User updatedUser) {
        Optional<User> userOpt = userService.findById(id);
        if (userOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        User user = userOpt.get();
        user.setUsername(updatedUser.getUsername());
        // Só atualiza a senha se tiver vindo no body
        if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
            user.setPassword(updatedUser.getPassword());
        }

        User savedUser = userService.save(user);
        return ResponseEntity.ok(savedUser);
    }

    // Deletar usuário
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        Optional<User> userOpt = userService.findById(id);
        if (userOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
