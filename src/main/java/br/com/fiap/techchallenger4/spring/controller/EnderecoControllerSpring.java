package br.com.fiap.techchallenger4.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.techchallenger4.logisticaentrega.dominio.controller.EnderecoController;

@RestController
@RequestMapping("/buscarenderecos")
public class EnderecoControllerSpring {
     @Autowired
     private EnderecoController controller;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> get(@RequestParam final String cep){
        try {
            return ResponseEntity.ok(controller.getEnderecoPeloCep(cep));
        } catch (Exception e) {
        	return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
