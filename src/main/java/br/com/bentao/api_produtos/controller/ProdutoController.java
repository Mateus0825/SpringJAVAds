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

import br.com.bentao.api_produtos.model.Produto;
import br.com.bentao.api_produtos.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository repository;

    public ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }

    // Criar novo produto
    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return repository.save(produto);
    }

    // Listar todos os produtos
    @GetMapping
    public List<Produto> listar() {
        return repository.findAll();
    }

    // Buscar produto por ID
    @GetMapping("/{id}")
    public Produto buscar(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    // Atualizar produto existente
    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto novoProduto) {
        Optional<Produto> produtoExistente = repository.findById(id);

        if (produtoExistente.isPresent()) {
            Produto produto = produtoExistente.get();
            produto.setNome(novoProduto.getNome());
            produto.setPreco(novoProduto.getPreco());
            return repository.save(produto);
        } else {
            return null; // se não encontrar, retorna null
        }
    }

    // Excluir produto por ID
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
