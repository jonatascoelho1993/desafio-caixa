package br.com.caixavidaeprevidencia.desafio.caixa.builders;

import br.com.caixavidaeprevidencia.desafio.caixa.commands.ProdutoCommand;
import br.com.caixavidaeprevidencia.desafio.caixa.dtos.ProdutoRequestDTO;

public class ProdutoCommandBuilder {

	private ProdutoCommandBuilder() {
		super();
	}
	
	public static ProdutoCommand build(ProdutoRequestDTO dto) {
		return ProdutoCommand.builder() //
				.descricao(dto.getDescricao())
				.preco(dto.getPreco())
				.build();
	}

}
