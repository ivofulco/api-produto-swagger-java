package com.exemplo.produtoapi.service;

import com.exemplo.produtoapi.model.Produto;
import com.exemplo.produtoapi.repository.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ProdutoServiceTest {

    @Mock
    private ProdutoRepository produtoRepository;

    @InjectMocks
    private ProdutoService produtoService;

    // Inicializa os mocks antes de cada teste
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveProduto() {
        Produto produto = new Produto(1L, "Produto Teste", 99.99);
        when(produtoRepository.save(produto)).thenReturn(produto);

        Produto savedProduto = produtoService.save(produto);

        assertNotNull(savedProduto);
        assertEquals(produto.getNome(), savedProduto.getNome());
    }
}
