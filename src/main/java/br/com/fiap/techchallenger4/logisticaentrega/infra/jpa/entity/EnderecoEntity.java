package br.com.fiap.techchallenger4.logisticaentrega.infra.jpa.entity;

import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.geo.Endereco;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.geo.EstadoBrasil;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.geo.TipoEnderecoEnum;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.exception.BusinessException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_endereco")
public class EnderecoEntity {
    @Id
    @Column(name = "cd_cep")
    private String cep;

    @Column(name = "cd_longitude", nullable = false)
    private double longitude;

    @Column(name = "cd_latitude", nullable = false)
    private double latitude;

    @Enumerated(EnumType.STRING)
    @Column(name="cd_estado", nullable = false)
    private EstadoBrasil estado;

    @Column(name = "nm_cidade", nullable = false)
    private String nomeCidade;

    @Column(name = "nm_bairro", nullable = false)
    private String nomeBairro;

    @Column(name = "nm_endereco", nullable = false)
    private String nomeEndreco;

    @Enumerated(EnumType.STRING)
    @Column(name = "cd_tipo_endereco", nullable = false)
    private TipoEnderecoEnum tipoEndereco;

    public Endereco to() throws BusinessException{
        return new Endereco(cep, longitude, latitude, estado, nomeCidade, nomeBairro, nomeEndreco, tipoEndereco);
    }
    
    public static EnderecoEntity to(Endereco endereco) {
    	return new EnderecoEntity(endereco.getCep(), endereco.getLongitude(), endereco.getLatitude(), endereco.getEstado(), endereco.getNomeCidade(), endereco.getNomeBairro(), endereco.getNomeEndreco(), endereco.getTipoEndereco());
    }
    
}
