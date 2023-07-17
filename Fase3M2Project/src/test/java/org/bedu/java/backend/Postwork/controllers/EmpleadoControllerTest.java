package org.bedu.java.backend.Postwork.controllers;

import org.bedu.java.backend.Postwork.model.Empleado;
import org.bedu.java.backend.Postwork.services.EmpleadoService;

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
@WebMvcTest(EmpleadoController.class)
class EmpleadoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmpleadoService empleadoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Obtener empleado específico")
    public void testGetEmpleado() throws Exception {
        Empleado empleado = new Empleado();
            empleado.setIdEmpleado(1L);
            empleado.setNombreEmpleado("Aaron Ríos");
            empleado.setCargo("Gerente");
            empleado.setTelefono("1234567890");
            empleado.setActividad("Supervisión");
            empleado.setNumeroEmpleado(1234);
        when(empleadoService.getEmpleado(eq(1L))).thenReturn(Optional.of(empleado));

        mockMvc.perform(get("/empleado/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.idEmpleado").value(empleado.getIdEmpleado()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nombreEmpleado").value(empleado.getNombreEmpleado()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cargo").value(empleado.getCargo()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.telefono").value(empleado.getTelefono()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.actividad").value(empleado.getActividad()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.numeroEmpleado").value(empleado.getNumeroEmpleado()))
                .andDo(document("empleado/get-empleado",
                        responseFields(
                                fieldWithPath("idEmpleado").description("ID del empleado"),
                                fieldWithPath("nombreEmpleado").description("Nombre del empleado"),
                                fieldWithPath("cargo").description("Cargo del empleado"),
                                fieldWithPath("telefono").description("Teléfono del empleado"),
                                fieldWithPath("actividad").description("Actividad del empleado"),
                                fieldWithPath("numeroEmpleado").description("Numero del empleado")
                        )));

    }

    @Test
    @DisplayName("Obtener todos los empleados")
    public void testGetEmpleados() throws Exception {

        List<Empleado> empleados = Arrays.asList(
                Empleado.builder().idEmpleado(1L).nombreEmpleado("Aaron Ríos").cargo("Gerente").telefono("1234567890").actividad("Supervisión").numeroEmpleado(1234).build(),
                Empleado.builder().idEmpleado(2L).nombreEmpleado("Nelly Ríos").cargo("Director").telefono("1234567890").actividad("Supervisión").numeroEmpleado(5678).build(),
                Empleado.builder().idEmpleado(3L).nombreEmpleado("Aaron Ríos").cargo("Gerente").telefono("1234567890").actividad("Supervisión").numeroEmpleado(9123).build()
        );
        given(empleadoService.getEmpleados()).willReturn(empleados);
        mockMvc.perform(MockMvcRequestBuilders.get("/empleado"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].idEmpleado").value(empleados.get(0).getIdEmpleado()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].idEmpleado").value(empleados.get(1).getIdEmpleado()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].idEmpleado").value(empleados.get(2).getIdEmpleado()))
                .andDo(document("empleado/get-empleados",
                        responseFields(
                                fieldWithPath("[].idEmpleado").description("ID del empleado"),
                                fieldWithPath("[].nombreEmpleado").description("Nombre del empleado"),
                                fieldWithPath("[].cargo").description("Cargo del empleado"),
                                fieldWithPath("[].telefono").description("Teléfono del empleado"),
                                fieldWithPath("[].actividad").description("Actividad del empleado"),
                                fieldWithPath("[].numeroEmpleado").description("Numero del empleado")
                        )));
    }

    @Test
    @DisplayName("Guardar empleado")
    public void testSaveEmpleado() throws Exception {
        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(1L);
        empleado.setNombreEmpleado("Aaron Ríos");
        empleado.setCargo("Gerente");
        empleado.setTelefono("1234567890");
        empleado.setActividad("Supervisión");
        empleado.setNumeroEmpleado(1234);
        when(empleadoService.saveEmpleado(any(Empleado.class))).thenReturn(empleado);
        mockMvc.perform(MockMvcRequestBuilders.post("/empleado")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"idEmpleado\": 1, \"nombreEmpleado\": \"Ricardo Rios\", \"cargo\":\"Gerente\", \"telefono\":1234567890, \"actividad\":\"Supervisión\", \"numeroEmpleado\":1234 }"))
                .andExpect(status().isCreated())
                .andDo(document("empleado/post-empleado",
                        requestFields(
                                fieldWithPath("idEmpleado").description("ID del empleado"),
                                fieldWithPath("nombreEmpleado").description("Nombre del empleado"),
                                fieldWithPath("cargo").description("Cargo del empleado"),
                                fieldWithPath("telefono").description("Teléfono del empleado"),
                                fieldWithPath("actividad").description("Actividad del empleado"),
                                fieldWithPath("numeroEmpleado").description("Numero del empleado")
                        ),
                        responseHeaders(
                                headerWithName("Location").description("La ubicación del recurso (su identificador generado)")
                        )));
    }

    @Test
    @DisplayName("Actualizar empleado")
    public void testUpdateEmpleado() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/empleado/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"idEmpleado\": 1, \"nombreEmpleado\": \"Ricardo Rios\", \"cargo\":\"Gerente\", \"telefono\":1234567890, \"actividad\":\"Supervisión\", \"numeroEmpleado\":1234 }"))
                .andExpect(MockMvcResultMatchers.status().isNoContent())
                .andDo(document("empleado/put-empleado",
                        requestFields(
                                fieldWithPath("idEmpleado").description("ID del empleado"),
                                fieldWithPath("nombreEmpleado").description("Nombre del empleado"),
                                fieldWithPath("cargo").description("Cargo del empleado"),
                                fieldWithPath("telefono").description("Teléfono del empleado"),
                                fieldWithPath("actividad").description("Actividad del empleado"),
                                fieldWithPath("numeroEmpleado").description("Numero del empleado")

                        )));
        verify(empleadoService, times(1)).updateEmpleado(any(Empleado.class));
    }

    @Test
    @DisplayName("Eliminar empleado")
    public void testDeleteEmpleado() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/empleado/1"))
                .andExpect(MockMvcResultMatchers.status().isNoContent())
                .andDo(document("empleado/delete-empleado"));
        verify(empleadoService, times(1)).deleteEmpleado(eq(1L));
    }
}