package com.exemplo.produtoapi.repository;

import com.exemplo.produtoapi.model.Produto;
import com.exemplo.produtoapi.repository.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProdutoRepositoryTest {

    @Autowired
    private ProdutoRepository produtoRepository;

    private Produto produto;

    @BeforeEach
    void setUp() {
        produto = new Produto(null, "Produto Teste", 10.0); // Id será gerado automaticamente
    }

    @Test
    void whenSaveProduto_thenProductIsSaved() {
        Produto savedProduto = produtoRepository.save(produto);
        assertNotNull(savedProduto.getId());  // Verificando se o ID foi gerado
    }
}
