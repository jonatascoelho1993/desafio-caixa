package br.com.caixavidaeprevidencia.desafio.caixa.builders;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import br.com.caixavidaeprevidencia.desafio.caixa.dtos.ProdutoDTO;
import br.com.caixavidaeprevidencia.desafio.caixa.entities.Produto;

public class ProdutoDTOBuilder {

	public ProdutoDTOBuilder() {
		super();
	}

	public static ProdutoDTO build(Produto produto) {
		return ProdutoDTO.builder() //
				.idProduto(produto.getIdProduto()) //
				.descricao(produto.getDescricao()) //
				.preco(produto.getPreco().doubleValue()) //
				.build();
	}

	public static List<ProdutoDTO> build(List<Produto> list) {
		if(list == null) return Collections.emptyList();
		
		return list.stream().map(ProdutoDTOBuilder::build).collect(Collectors.toList());
	}

}
