package com.exemplo.produtoapi.controller;

import com.exemplo.produtoapi.model.Produto;
import com.exemplo.produtoapi.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProdutoController.class)
class ProdutoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProdutoService produtoService;

    @Test
    void whenGetProduto_thenReturnsStatusOk() throws Exception {
        Produto produto = new Produto(1L, "Produto 1", 10.0);

        //when(produtoService.findById(1L)).thenReturn(produto);
        when(produtoService.findById(1L)).thenReturn(new Produto(1L, "Produto 1", 10.0));


        mockMvc.perform(get("/api/produtos/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.nome").value("Produto 1"))
                .andExpect(jsonPath("$.preco").value(10.0));
    }
}
