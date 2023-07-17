package org.bedu.java.backend.Postwork.controllers;

import org.bedu.java.backend.Postwork.model.Pedido;
import org.bedu.java.backend.Postwork.services.PedidoService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.responseHeaders;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureRestDocs(uriScheme = "https", uriHost = "bedu.org/rest", uriPort = 80)
@WebMvcTest(PedidoController.class)
class PedidoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PedidoService pedidoService;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Obtener pedido especifico")
    public void testGetPedido() throws Exception {
       Pedido pedido = new Pedido();
                pedido.setId(1L);
                pedido.setCliente("Lukas-soft");
                pedido.setEquipo("Motor nuevo");
                pedido.setPotencia(450);
                pedido.setUnidadMedida("Hp");
                pedido.setRpm(60);
                pedido.setFrecuencia(24);
                pedido.setFecha("13/07/2023");
                pedido.setAmperes(12);
                pedido.setArmazon("182/4T");
                pedido.setMarca("Siemmens");
                pedido.setSerie("AM15264");
                pedido.setDesensamble("Ricardo Ríos");
                pedido.setEnsamble("Nelly Ríos");
                pedido.setEmbobinado("Gloria Ríos");
                pedido.setPruebas("Paty Avila");
                pedido.setNotas("Funcionando");
                pedido.setEstatus("Terminado");
                pedido.setFactura("F1212");
        when(pedidoService.getPedido(eq(1L))).thenReturn(Optional.of(pedido));

        mockMvc.perform(get("/pedido/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(pedido.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cliente").value(pedido.getCliente()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.equipo").value(pedido.getEquipo()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.potencia").value(pedido.getPotencia()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.unidadMedida").value(pedido.getUnidadMedida()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rpm").value(pedido.getRpm()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.frecuencia").value(pedido.getFrecuencia()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.fecha").value(pedido.getFecha()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.amperes").value(pedido.getAmperes()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.armazon").value(pedido.getArmazon()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.marca").value(pedido.getMarca()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.serie").value(pedido.getSerie()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.desensamble").value(pedido.getDesensamble()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.ensamble").value(pedido.getEnsamble()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.embobinado").value(pedido.getEmbobinado()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.pruebas").value(pedido.getPruebas()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.notas").value(pedido.getNotas()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.estatus").value(pedido.getEstatus()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.factura").value(pedido.getFactura()))
                .andDo(document("pedido/get-pedido",
                        responseFields(
                                fieldWithPath("id").description("ID del pedido"),
                                fieldWithPath("cliente").description("Nombre del cliente"),
                                fieldWithPath("equipo").description("Tipo de equipo"),
                                fieldWithPath("fecha").description("Fecha de trabajo"),
                                fieldWithPath("potencia").description("Potencia del equipo"),
                                fieldWithPath("unidadMedida").description("Unidad de medida del equipo"),
                                fieldWithPath("rpm").description("RPM del equipo"),
                                fieldWithPath("frecuencia").description("Frecuencia del equipo"),
                                fieldWithPath("amperes").description("Amperes del equipo"),
                                fieldWithPath("armazon").description("Armazon del equipo"),
                                fieldWithPath("marca").description("Marca del equipo"),
                                fieldWithPath("serie").description("Serie del equipo"),
                                fieldWithPath("desensamble").description("Desensamblaje del equipo"),
                                fieldWithPath("ensamble").description("Ensamblaje del equipo"),
                                fieldWithPath("embobinado").description("Embobinado del equipo"),
                                fieldWithPath("pruebas").description("Pruebas del equipo"),
                                fieldWithPath("notas").description("Notas del equipo"),
                                fieldWithPath("estatus").description("Estatus del equipo"),
                                fieldWithPath("factura").description("Factura del equipo")
                        )));
    }

    @Test
    @DisplayName("Obtener todos los pedidos")
    public void testGetPedidos() throws Exception {

        List<Pedido> pedidos = Arrays.asList(
                Pedido.builder().id(1L).cliente("Lukasoft").equipo("Motorreductor").fecha("13/07/2023").potencia(2).unidadMedida("Hp").rpm(1200).frecuencia(60)
                        .amperes(15).armazon("124/20").marca("Siemmens").serie("SN123456").desensamble("Ricardo Ríos").ensamble("Nelly Ríos")
                        .embobinado("Gloria Ríos").pruebas("Paty Avila").notas("Funcionando").estatus("Terminado").factura("F1234").build(),
                Pedido.builder().id(2L).cliente("Lukasoft").equipo("Motorreductor").fecha("13/07/2023").potencia(2).unidadMedida("Hp").rpm(1200).frecuencia(60)
                        .amperes(15).armazon("124/20").marca("Siemmens").serie("SN123456").desensamble("Ricardo Ríos").ensamble("Nelly Ríos")
                        .embobinado("Gloria Ríos").pruebas("Paty Avila").notas("Funcionando").estatus("Terminado").factura("F1234").build(),
                Pedido.builder().id(3L).cliente("Lukasoft").equipo("Motorreductor").fecha("13/07/2023").potencia(2).unidadMedida("Hp").rpm(1200).frecuencia(60)
                        .amperes(15).armazon("124/20").marca("Siemmens").serie("SN123456").desensamble("Ricardo Ríos").ensamble("Nelly Ríos")
                        .embobinado("Gloria Ríos").pruebas("Paty Avila").notas("Funcionando").estatus("Terminado").factura("F1234").build()
                );
        given(pedidoService.getPedidos()).willReturn(pedidos);

        mockMvc.perform(MockMvcRequestBuilders.get("/pedido"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(pedidos.get(0).getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].cliente").value(pedidos.get(0).getCliente()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].equipo").value(pedidos.get(0).getEquipo()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].fecha").value(pedidos.get(0).getFecha()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].potencia").value(pedidos.get(0).getPotencia()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].unidadMedida").value(pedidos.get(0).getUnidadMedida()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].rpm").value(pedidos.get(0).getRpm()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].frecuencia").value(pedidos.get(0).getFrecuencia()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].amperes").value(pedidos.get(0).getAmperes()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].armazon").value(pedidos.get(0).getArmazon()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].marca").value(pedidos.get(0).getMarca()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].serie").value(pedidos.get(0).getSerie()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].desensamble").value(pedidos.get(0).getDesensamble()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].ensamble").value(pedidos.get(0).getEnsamble()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].embobinado").value(pedidos.get(0).getEmbobinado()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].pruebas").value(pedidos.get(0).getPruebas()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].notas").value(pedidos.get(0).getNotas()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].estatus").value(pedidos.get(0).getEstatus()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].factura").value(pedidos.get(0).getFactura()))

                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(pedidos.get(1).getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].cliente").value(pedidos.get(1).getCliente()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].equipo").value(pedidos.get(1).getEquipo()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].fecha").value(pedidos.get(1).getFecha()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].potencia").value(pedidos.get(1).getPotencia()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].unidadMedida").value(pedidos.get(1).getUnidadMedida()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].rpm").value(pedidos.get(1).getRpm()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].frecuencia").value(pedidos.get(1).getFrecuencia()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].amperes").value(pedidos.get(1).getAmperes()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].armazon").value(pedidos.get(1).getArmazon()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].marca").value(pedidos.get(1).getMarca()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].serie").value(pedidos.get(1).getSerie()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].desensamble").value(pedidos.get(1).getDesensamble()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].ensamble").value(pedidos.get(1).getEnsamble()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].embobinado").value(pedidos.get(1).getEmbobinado()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].pruebas").value(pedidos.get(1).getPruebas()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].notas").value(pedidos.get(1).getNotas()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].estatus").value(pedidos.get(1).getEstatus()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].factura").value(pedidos.get(1).getFactura()))

                .andExpect(MockMvcResultMatchers.jsonPath("$[2].id").value(pedidos.get(2).getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].cliente").value(pedidos.get(2).getCliente()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].equipo").value(pedidos.get(2).getEquipo()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].fecha").value(pedidos.get(2).getFecha()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].potencia").value(pedidos.get(2).getPotencia()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].unidadMedida").value(pedidos.get(2).getUnidadMedida()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].rpm").value(pedidos.get(2).getRpm()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].frecuencia").value(pedidos.get(2).getFrecuencia()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].amperes").value(pedidos.get(2).getAmperes()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].armazon").value(pedidos.get(2).getArmazon()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].marca").value(pedidos.get(2).getMarca()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].serie").value(pedidos.get(2).getSerie()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].desensamble").value(pedidos.get(2).getDesensamble()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].ensamble").value(pedidos.get(2).getEnsamble()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].embobinado").value(pedidos.get(2).getEmbobinado()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].pruebas").value(pedidos.get(2).getPruebas()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].notas").value(pedidos.get(2).getNotas()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].estatus").value(pedidos.get(2).getEstatus()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].factura").value(pedidos.get(2).getFactura()))
                .andDo(document("pedido/get-pedidos",
                        responseFields(
                                fieldWithPath("[].id").description("ID del pedido"),
                                fieldWithPath("[].cliente").description("Nombre del cliente"),
                                fieldWithPath("[].equipo").description("Tipo de equipo"),
                                fieldWithPath("[].fecha").description("Fecha de trabajo"),
                                fieldWithPath("[].potencia").description("Potencia del equipo"),
                                fieldWithPath("[].unidadMedida").description("Unidad de medida del equipo"),
                                fieldWithPath("[].rpm").description("RPM del equipo"),
                                fieldWithPath("[].frecuencia").description("Frecuencia del equipo"),
                                fieldWithPath("[].amperes").description("Amperes del equipo"),
                                fieldWithPath("[].armazon").description("Armazon del equipo"),
                                fieldWithPath("[].marca").description("Marca del equipo"),
                                fieldWithPath("[].serie").description("Serie del equipo"),
                                fieldWithPath("[].desensamble").description("Desensamblaje del equipo"),
                                fieldWithPath("[].ensamble").description("Ensamblaje del equipo"),
                                fieldWithPath("[].embobinado").description("Embobinado del equipo"),
                                fieldWithPath("[].pruebas").description("Pruebas del equipo"),
                                fieldWithPath("[].notas").description("Notas del equipo"),
                                fieldWithPath("[].estatus").description("Estatus del equipo"),
                                fieldWithPath("[].factura").description("Factura del equipo")
                        )));

    }

    @Test
    @DisplayName("Guardar pedido")
    public void testSavePedido() throws Exception {
        Pedido pedido = new Pedido();
        pedido.setId(1L);
        pedido.setCliente("Lukas-soft");
        pedido.setEquipo("Motor nuevo");
        pedido.setFecha("13/07/2023");
        pedido.setPotencia(450);
        pedido.setUnidadMedida("Hp");
        pedido.setRpm(60);
        pedido.setFrecuencia(24);
        pedido.setAmperes(12);
        pedido.setArmazon("182/4T");
        pedido.setMarca("Siemmens");
        pedido.setSerie("AM15264");
        pedido.setDesensamble("Ricardo Ríos");
        pedido.setEnsamble("Nelly Ríos");
        pedido.setEmbobinado("Gloria Ríos");
        pedido.setPruebas("Paty Avila");
        pedido.setNotas("Funcionando");
        pedido.setEstatus("Terminado");
        pedido.setFactura("F1212");
        when(pedidoService.savePedido(any(Pedido.class))).thenReturn(pedido);

        mockMvc.perform(MockMvcRequestBuilders.post("/pedido")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": 1,\"cliente\": \"Aaron Ríos\", \"equipo\": \"Motor Nuevo\",\"fecha\": \"13/07/2023\", \"potencia\":  10 , \"unidadMedida\": \"Hp\", \"rpm\": 1200, \"frecuencia\": 60, \"amperes\":  80 , \"armazon\": \"124/7\", \"marca\": \"Siemmens\", \"serie\": \"SN12456\", \"desensamble\": \"Ricardo Ríos\", \"ensamble\": \"Nelly Ríos\", \"embobinado\": \"Gloria Ríos\", \"pruebas\": \"Paty AVila\", \"notas\": \"Funcionando\", \"estatus\": \"Terminado\", \"factura\": \"F1234\"}"))
                .andExpect(status().isCreated())

                .andDo(document("pedido/post-pedido",
                        requestFields(
                                fieldWithPath("id").description("ID del pedido"),
                                fieldWithPath("cliente").description("Nombre del cliente"),
                                fieldWithPath("equipo").description("Tipo de equipo"),
                                fieldWithPath("fecha").description("Fecha de trabajo"),
                                fieldWithPath("potencia").description("Potencia del equipo"),
                                fieldWithPath("unidadMedida").description("Unidad de medida del equipo"),
                                fieldWithPath("rpm").description("RPM del equipo"),
                                fieldWithPath("frecuencia").description("Frecuencia del equipo"),
                                fieldWithPath("amperes").description("Amperes del equipo"),
                                fieldWithPath("armazon").description("Armazon del equipo"),
                                fieldWithPath("marca").description("Marca del equipo"),
                                fieldWithPath("serie").description("Serie del equipo"),
                                fieldWithPath("desensamble").description("Desensamblaje del equipo"),
                                fieldWithPath("ensamble").description("Ensamblaje del equipo"),
                                fieldWithPath("embobinado").description("Embobinado del equipo"),
                                fieldWithPath("pruebas").description("Pruebas del equipo"),
                                fieldWithPath("notas").description("Notas del equipo"),
                                fieldWithPath("estatus").description("Estatus del equipo"),
                                fieldWithPath("factura").description("Factura del equipo")
                        ),
                        responseHeaders(
                                headerWithName("Location").description("La ubicación del recurso (su identificador generado)")
                        ))
                );
    }

    @Test
    @DisplayName("Actualizar pedido")
    public void testUpdatePedido() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/pedido/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": 1,\"cliente\": \"Aaron Ríos\", \"equipo\": \"Motor Nuevo\",\"fecha\": \"13/07/2023\", \"potencia\":  10 , \"unidadMedida\": \"Hp\", \"rpm\": 1200, \"frecuencia\": 60, \"amperes\":  80 , \"armazon\": \"124/7\", \"marca\": \"Siemmens\", \"serie\": \"SN12456\", \"desensamble\": \"Ricardo Ríos\", \"ensamble\": \"Nelly Ríos\", \"embobinado\": \"Gloria Ríos\", \"pruebas\": \"Paty AVila\", \"notas\": \"Funcionando\", \"estatus\": \"Terminado\", \"factura\": \"F1234\"}"))
                .andExpect(MockMvcResultMatchers.status().isNoContent())
                .andDo(document("pedido/put-pedido",
                        requestFields(
                                fieldWithPath("id").description("ID del pedido"),
                                fieldWithPath("cliente").description("Nombre del cliente"),
                                fieldWithPath("equipo").description("Tipo de equipo"),
                                fieldWithPath("fecha").description("Fecha de trabajo"),
                                fieldWithPath("potencia").description("Potencia del equipo"),
                                fieldWithPath("unidadMedida").description("Unidad de medida del equipo"),
                                fieldWithPath("rpm").description("RPM del equipo"),
                                fieldWithPath("frecuencia").description("Frecuencia del equipo"),
                                fieldWithPath("amperes").description("Amperes del equipo"),
                                fieldWithPath("armazon").description("Armazon del equipo"),
                                fieldWithPath("marca").description("Marca del equipo"),
                                fieldWithPath("serie").description("Serie del equipo"),
                                fieldWithPath("desensamble").description("Desensamblaje del equipo"),
                                fieldWithPath("ensamble").description("Ensamblaje del equipo"),
                                fieldWithPath("embobinado").description("Embobinado del equipo"),
                                fieldWithPath("pruebas").description("Pruebas del equipo"),
                                fieldWithPath("notas").description("Notas del equipo"),
                                fieldWithPath("estatus").description("Estatus del equipo"),
                                fieldWithPath("factura").description("Factura del equipo")
                        )));
        verify(pedidoService, times(1)).updatePedido(any(Pedido.class));
    }

    @Test
    @DisplayName("Eliminar pedido")
    public void testDeletePedido() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/pedido/1"))
                .andExpect(MockMvcResultMatchers.status().isNoContent())
                .andDo(document("pedido/delete-pedido"));
        verify(pedidoService, times(1)).deletePedido(eq(1L));
    }
}