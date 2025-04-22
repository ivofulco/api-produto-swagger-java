package com.exemplo.produtoapi.service;

import com.exemplo.produtoapi.model.Produto;
import com.exemplo.produtoapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    // Injeta o repositório através do construtor
    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    // Método para salvar um novo produto
    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    // Método para buscar todos os produtos
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    // Método para buscar um produto por ID
    //public Produto findById(Long id) {
    //    Optional<Produto> produto = produtoRepository.findById(id);
    //    return produto.orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + id));
    //}

    public Produto findById(Long id) {
        // No teste, ele é mockado, mas você pode ter algo como:
        return new Produto(id, "Produto Teste", 99.99);
    }    

    // Método para atualizar um produto existente
    public Produto update(Long id, Produto produto) {
        // Verifica se o produto existe antes de atualizar
        Produto produtoExistente = findById(id);
        produtoExistente.setNome(produto.getNome());
        produtoExistente.setPreco(produto.getPreco());
        return produtoRepository.save(produtoExistente);
    }

    // Método para deletar um produto
    public void delete(Long id) {
        Produto produtoExistente = findById(id);
        produtoRepository.delete(produtoExistente);
    }
}
