package br.com.fiap.techchallenger4.spring.controller;

import br.com.fiap.estrutura.exception.BusinessException;
import br.com.fiap.estrutura.swagger.annotations.responses.ApiResponseBadRequestJson;
import br.com.fiap.estrutura.swagger.annotations.responses.ApiResponseNoContentJson;
import br.com.fiap.estrutura.utils.SpringControllerUtils;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.controller.EntregaController;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega.Entrega;
import br.com.fiap.techchallenger4.spring.jpa.entity.EntregaEntity;
import br.com.fiap.techchallenger4.spring.jpa.repository.EntregaRepositorySpring;
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

    @Autowired
    private EntregaRepositorySpring entregaRepositorySpring;

    @GetMapping(path = "/buscarEntregasId", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Buscar entrega por id")
    public ResponseEntity<?> get(@RequestParam final Long codigoEntrega) throws BusinessException {
        if (entregaRepositorySpring.existsById(codigoEntrega)) {
            return SpringControllerUtils.response(HttpStatus.OK, () -> entregaController.getEntregaPorId(codigoEntrega));
        }
        throw new BusinessException("Id de entrega inválido");
    }

    @GetMapping(path = "/buscarEntregas", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Buscar entregas sem data prevista")
    public ResponseEntity<?> getAll() throws BusinessException {
        List<Entrega> entregasAll = entregaController.getAll();
        if(entregasAll.isEmpty()){
            throw new BusinessException("Nenhuma entrega encontrada");
        }
        return SpringControllerUtils.response(HttpStatus.OK, () -> entregasAll);
    }

    @PutMapping(path = "/atualizarEntrega", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponseNoContentJson
    @ApiResponseBadRequestJson
    @Operation(summary = "Atualiza entrega vinculando entregador")
    public ResponseEntity<?> atualizarEntrega(@RequestParam Long idEntrega, @RequestParam Long idEntregador) throws BusinessException{

        return SpringControllerUtils.response(HttpStatus.OK, () -> entregaController.atualizarEntrega(idEntrega, idEntregador));
    }
}
