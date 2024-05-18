package br.com.fiap.techchallenger4.spring.controller;

import br.com.fiap.techchallenger4.spring.jpa.entity.EntregaEntity;
import br.com.fiap.techchallenger4.spring.jpa.entity.EntregadorEntity;
import br.com.fiap.techchallenger4.spring.jpa.repository.EntregaRepositorySpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.estrutura.exception.BusinessException;
import br.com.fiap.estrutura.swagger.annotations.responses.ApiResponseBadRequestJson;
import br.com.fiap.estrutura.swagger.annotations.responses.ApiResponseNoContentJson;
import br.com.fiap.estrutura.utils.SpringControllerUtils;
import br.com.fiap.techchallenger4.spring.jpa.entity.PedidoEntity;
import br.com.fiap.techchallenger4.spring.jpa.repository.PedidoRepositorySpring;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Endpoint para envio de pedidos para Logistica")
public class PedidoControllerSpring {
    @Autowired
    private PedidoRepositorySpring pedidoRepository;

    @Autowired
    private EntregaRepositorySpring entregaRepository;

    @PostMapping(path="/logistica/processar/pedido", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponseNoContentJson
    @ApiResponseBadRequestJson
    @Operation(summary = "Insere pedido para ser processado pela logistica")
    public ResponseEntity<?> post(@RequestBody final PedidoEntity pedido){

        return SpringControllerUtils.response(HttpStatus.NO_CONTENT, () -> {
            if(pedido.getStatusPedido().equalsIgnoreCase("AGUARDANDO_ENTREGA")){
            	pedidoRepository.save(pedido);
                entregaRepository.save(new EntregaEntity(pedido));
                return null;
            }
            throw new BusinessException("Apenas pedidos com status Aguardando Entrega, podem ser enviados para logistica");
        });

    }

}
