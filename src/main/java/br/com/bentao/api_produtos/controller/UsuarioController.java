package br.com.bentao.api_produtos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bentao.api_produtos.model.Usuario;
import br.com.bentao.api_produtos.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    // Criar novo usuário
    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario) {
        return repository.save(usuario);
    }

    // Listar todos os usuários
    @GetMapping
    public List<Usuario> listar() {
        return repository.findAll();
    }

    // Buscar usuário por ID
    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    // Atualizar usuário existente
    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario novoUsuario) {
        Optional<Usuario> usuarioExistente = repository.findById(id);

        if (usuarioExistente.isPresent()) {
            Usuario usuario = usuarioExistente.get();
            usuario.setCpf(novoUsuario.getCpf());
            usuario.setDataNascimento(novoUsuario.getDataNascimento());
            usuario.setEmail(novoUsuario.getEmail());
            usuario.setEndereco(novoUsuario.getEndereco());
            usuario.setNome(novoUsuario.getNome());
            return repository.save(usuario);
        } else {
            return null; // se não encontrar, retorna null
        }
    }

    // Excluir usuário por ID
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
