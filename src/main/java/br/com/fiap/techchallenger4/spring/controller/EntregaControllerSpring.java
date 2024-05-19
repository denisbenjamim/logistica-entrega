package br.com.fiap.techchallenger4.spring.controller;

import br.com.fiap.estrutura.exception.BusinessException;
import br.com.fiap.estrutura.swagger.annotations.ApiResponseSwaggerNoContent;
import br.com.fiap.estrutura.utils.SpringControllerUtils;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.controller.EntregaController;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega.Entrega;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Api Entrega")
public class EntregaControllerSpring {

    @Autowired
    private EntregaController entregaController;

    @GetMapping(path = "/buscarEntregasId", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Buscar entrega por id")
    public ResponseEntity<?> get(@RequestParam final Long codigoEntrega){

            return SpringControllerUtils.response(HttpStatus.OK, () -> entregaController.getEntregaPorId(codigoEntrega));
    }

    @GetMapping(path = "/buscarEntregas", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Buscar entregas sem data prevista")
    public ResponseEntity<?> getAllEntregas() throws BusinessException {
        List<Entrega> entregasAll = entregaController.getAll();

        return SpringControllerUtils.response(HttpStatus.OK, () -> entregasAll);
    }

    @PutMapping(path = "/atualizarEntrega")
    @ApiResponseSwaggerNoContent
    @Operation(summary = "Atualiza entrega vinculando entregador")
    public ResponseEntity<?> atualizarEntrega(@RequestParam Long idEntrega, @RequestParam Long idEntregador) {
        return SpringControllerUtils.response(HttpStatus.NO_CONTENT, () -> {
            entregaController.atualizarEntrega(idEntrega, idEntregador);
            return null;
        });
    }

    @PutMapping(path = "/encerrarEntrega")
    @ApiResponseSwaggerNoContent
    @Operation(summary = "Encerra uma entrega")
    public ResponseEntity<?> atualizarEntrega(@RequestParam Long idEntrega) {
        return SpringControllerUtils.response(HttpStatus.NO_CONTENT, () -> {
            entregaController.encerrarEntrega(idEntrega);
            return null;
        });
    }

}
