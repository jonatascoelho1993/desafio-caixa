package br.com.caixavidaeprevidencia.desafio.caixa.entities;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "produto")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JoinColumn(name = "id_produto")
	private Long idProduto;
	
	@JoinColumn(name = "descricao")
	private String descricao;
	
	@JoinColumn(name = "preco")
	private BigDecimal preco;
	
}
