package com.sisumupa.sisumupa_backend.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sisumupa.sisumupa_backend.domain.Associado;
import com.sisumupa.sisumupa_backend.service.AssociadoService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.Optional;


@WebMvcTest(AssociadoController.class)
public class AssociadoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private AssociadoService associadoService;

    @InjectMocks
    private AssociadoController associadoController;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(associadoController).build();
    }

    @Test
    void testBuscarTodosAssociados() throws Exception {
        Associado associado1 = new Associado(1L, "João", "Silva");
        Associado associado2 = new Associado(2L, "Maria", "Oliveira");
        when(associadoService.buscarTodosAssociados()).thenReturn(Arrays.asList(associado1, associado2));

        mockMvc.perform(get("/api/v1/associados"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].nome").value("João"))
                .andExpect(jsonPath("$[1].nome").value("Maria"));
    }

    @Test
    void testBuscarAssociadoPorId() throws Exception {
        Associado associado = new Associado(1L, "João", "Silva");
        when(associadoService.readAssociado(1L)).thenReturn(associado);

        mockMvc.perform(get("/api/v1/associados/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.nome").value("João"));
    }

    @Test
    void testCriarAssociado() throws Exception {
        Associado associado = new Associado(1L, "João", "Silva");
        when(associadoService.createAssociado(any(Associado.class))).thenReturn(associado);

        mockMvc.perform(post("/api/v1/associados")
                .contentType("application/json")
                .content(new ObjectMapper().writeValueAsString(associado)))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.nome").value("João"));
    }

    @Test
    void testAtualizarAssociado() throws Exception {
        Associado associado = new Associado(1L, "João", "Silva");
        when(associadoService.updateAssociado(any(Associado.class))).thenReturn(associado);

        mockMvc.perform(put("/api/v1/associados/1")
                .contentType("application/json")
                .content(new ObjectMapper().writeValueAsString(associado)))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.nome").value("João"));
    }

    @Test
    void testExcluirAssociado() throws Exception {
        doNothing().when(associadoService).deleteAssociado(1L);

        mockMvc.perform(delete("/api/v1/associados/1"))
                .andExpect(status().isOk());
    }
}