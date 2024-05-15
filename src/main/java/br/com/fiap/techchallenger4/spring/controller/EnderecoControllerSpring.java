package br.com.fiap.techchallenger4.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.estrutura.swagger.annotations.ApiResponseSwaggerOk;
import br.com.fiap.estrutura.utils.SpringControllerUtils;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.controller.EnderecoController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Api Endereço")
public class EnderecoControllerSpring {
    @Autowired
    private EnderecoController controller;

    @PostMapping(path="/buscarenderecos", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponseSwaggerOk
    @Operation(summary = "Buscar endereço por CEP")
    public ResponseEntity<?> post(@RequestParam final String cep){
        return SpringControllerUtils.response(HttpStatus.OK, () -> controller.getEnderecoPeloCep(cep));
    }

}
