package br.com.fiap.techchallenger4.spring.controller;

import static io.restassured.RestAssured.given;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import io.restassured.RestAssured;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EntregaControllerSpringTest {

    @LocalServerPort
    private int porta;

    @BeforeEach
    void setUp() {
        RestAssured.port = porta;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    void deveBuscarEntregaPorId() {
        given()
            .param("codigoEntrega", 1)
        .when()
            .get("/buscarEntregasId")
        .then()
            .statusCode(HttpStatus.SC_OK);
    }

    @Test
    void naoDeveBuscarEntregaSeIdForNull() {
        given()
            .param("codigoEntrega", (Long)null)
        .when()
            .get("/buscarEntregasId")
        .then()
            .statusCode(HttpStatus.SC_BAD_REQUEST); 
    }

    @Test
    void naoDeveBuscarEntregaSeIdForZero() {
        given()
            .param("codigoEntrega", 0)
        .when()
            .get("/buscarEntregasId")
        .then()
            .statusCode(HttpStatus.SC_BAD_REQUEST);
        }

    @Test
    void deveBuscarTodasAsEntregas() {
        given()
            .when()
                .get("/buscarEntregas")
            .then()
                .statusCode(HttpStatus.SC_OK); 
    }

    @Test
    void deveAtualizarEntregaVinculandoEntregador() {
        
        given()
            .param("idEntrega", 1L)
            .param("idEntregador", 1L)
        .when()
            .put("/atualizarEntrega")
        .then()
            .statusCode(HttpStatus.SC_OK);
    }

   
    }
