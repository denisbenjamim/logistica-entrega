package br.com.fiap.techchallenger4.spring.controller;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.fiap.techchallenger4.spring.jpa.entity.EntregadorEntity;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EntregadorControllerSpringTest {

    @LocalServerPort
    private int porta;

    @BeforeEach
    void setUp() {
        RestAssured.port = porta;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    void naoDeveCriarEntregadorCasoIdDoEntregadorSejaNull() {
        
        given()
            .contentType(ContentType.JSON)
            .body("""
                {
                    "idEntregador" : "",
                    "nome": Lukas,
                    "cpf": "12345678,
                    "numeroTelefone": "61985325012"
                }
                """)            
        .when()
            .post("/criarEntregador")
        .then()
            .statusCode(HttpStatus.SC_BAD_REQUEST);
        }

    @Test
    void naoDeveCriarEntregadorCasoIdDoEntregadorSejaZero() {
        given()
            .contentType(ContentType.JSON)
            .body("""
                {
                    "idEntregador" : 0 ,
                    "nome": Lukas,
                    "cpf": "12345678,
                    "numeroTelefone": "61985325012"
                }
                """)            
        .when()
            .post("/criarEntregador")
        .then()
            .statusCode(HttpStatus.SC_BAD_REQUEST);
        }

    @Test
    void deveCriarEntregador() {
        EntregadorEntity inputEntity = new EntregadorEntity();
        inputEntity.setIdEntregador(1L);
        inputEntity.setNome("Nome");
        inputEntity.setCpf("12345678");
        inputEntity.setNumeroTelefone("6185203215");

        given()
            .contentType(ContentType.JSON)
            .body(inputEntity)
        .when()
            .post("/criarEntregador")
        .then()
            .statusCode(HttpStatus.SC_OK);
    }

    @Test
    void deveBuscarEntregadorPeloId() {
        given()
            .param("idEntregador", 1)
        .when()
            .get("/buscarEntregador")
        .then()
            .statusCode(HttpStatus.SC_OK);
    }

    @Test
    void naoDeveBuscarEntregadorSeIdForNull() {
        Long idEntregadorNull = null;
        given()
            .param("idEntregador", idEntregadorNull)
        .when()
            .get("/buscarEntregador")
        .then()
            .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    void naoDeveBuscarEntregadorSeIdForZero() {
        given()
            .param("idEntregador", 0)
        .when()
            .get("/buscarEntregador")
        .then()
            .statusCode(HttpStatus.SC_BAD_REQUEST);
    }
}