package com.matera.ContaService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.matera.ContaService.dto.ContaRequestDTO;
import com.matera.ContaService.dto.ContaResponseDTO;
import com.matera.ContaService.service.ContaService;
import com.matera.ContaService.service.PixService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

@WebMvcTest
public class ContaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private ContaService contaService;

    @MockitoBean
    private PixService pixService;

    @Test
    void deveCriarContaComSucesso() throws Exception {
        ContaRequestDTO request = ContaRequestDTO.builder()
                .nome("Pingo")
                .agencia(1234)
                .conta(56789)
                .chavePix("pingo@pix")
                .build();

        UUID idContaSalva = UUID.randomUUID();

        ContaResponseDTO response = ContaResponseDTO.builder()
                .id(idContaSalva)
                .nome(request.getNome())
                .build();

        when(contaService.criarConta(request)).thenReturn(response);

        mockMvc.perform(post("/api/contas")
                        .content(objectMapper.writeValueAsString(request))
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(jsonPath("id").exists())
                        .andExpect(jsonPath("nome").value("Pingo"))
                        .andExpect(status().isCreated());
    }
}
