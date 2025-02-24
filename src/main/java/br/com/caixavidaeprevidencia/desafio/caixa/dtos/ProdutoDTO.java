package br.com.caixavidaeprevidencia.desafio.caixa.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdutoDTO {
	
	private Long idProduto;
	private String descricao;
	private Double preco;
	
}
