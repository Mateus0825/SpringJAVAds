package br.com.bentao.api_produtos.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bentao.api_produtos.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByNome (String nome);
    List<Usuario> findByNomeContaining (String parteDoNome);
    
}