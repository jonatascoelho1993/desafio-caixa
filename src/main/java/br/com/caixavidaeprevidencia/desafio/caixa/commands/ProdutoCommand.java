package br.com.caixavidaeprevidencia.desafio.caixa.commands;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdutoCommand {

	private String descricao;
	private Double preco;

}
