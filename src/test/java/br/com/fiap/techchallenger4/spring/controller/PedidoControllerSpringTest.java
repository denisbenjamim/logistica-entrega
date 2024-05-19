package br.com.fiap.techchallenger4.spring.controller;

import static io.restassured.RestAssured.given;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PedidoControllerSpringTest {

    @LocalServerPort
    private int porta;

    @BeforeEach
    void setUp() {
        RestAssured.port = porta;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
       
    }

    @Test
    void deveInserirPedidoParaSerProcessadoNaLogistica(){
        given()
            .contentType(ContentType.JSON)
            .body("""
                {
                    "codigoPedido": 4,
                    "codigoCliente": 4,
                    "dataCriacao": "2024-05-19T06:43:13.748Z",
                    "statusPedido": "Aguardando_Entrega",
                    "cep": "79852101",
                    "numeroEndereco": "20",
                    "complementoEndereco": "Rua",
                    "produtos": [
                      {
                        "codigoProduto": 1,
                        "quantidade": 10
                      }
                    ]
                  }
                """)
                .when()
                    .post("/logistica/processar/pedido")
                .then()
                    .statusCode(HttpStatus.SC_NO_CONTENT);
                }

    @Test
    void naoDeveCriarPedidoCasoIdDoPedidoJáExista() {
        
        given()
            .contentType(ContentType.JSON)
            .body("""
                {
                    "codigoPedido": "1",
                    "codigoCliente": 1,
                    "dataCriacao": "2024-05-18T19:00:00",
                    "statusPedido": "Aguardando_Entrega",
                    "cep": "70652178",
                    "numeroEndereco": "52",
                    "complementoEndereco": "Rua"
                }
                """)            
        .when()
            .post("/logistica/processar/pedido")
        .then()
            .statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
        }

        @Test
    void naoDeveCriarPedidoCasoStatusDoPedidoSejaDiferenteDeAguardandoEntrega() {
        String jsonPedido = """
        {
            "codigoPedido": 4,
            "codigoCliente": 4,
            "dataCriacao": "2024-05-18T19:00:00",
            "statusPedido": "Entregue",
            "cep": "70652178",
            "numeroEndereco": "52",
            "complementoEndereco": "Rua"
        }
    """;
        given()
            .contentType(ContentType.JSON)
            .body(jsonPedido)            
        .when()
            .post("/logistica/processar/pedido")
        .then()
            .statusCode(HttpStatus.SC_BAD_REQUEST);
        }
}
