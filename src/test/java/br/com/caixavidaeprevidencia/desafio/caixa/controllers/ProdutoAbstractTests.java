package br.com.caixavidaeprevidencia.desafio.caixa.controllers;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.caixavidaeprevidencia.desafio.caixa.entities.Produto;
import br.com.caixavidaeprevidencia.desafio.caixa.repositories.ProdutoRepository;
import br.com.caixavidaeprevidencia.desafio.caixa.util.math.Amount;

public abstract class ProdutoAbstractTests {
	
	@Autowired
	MockMvc mockMvc;

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	ObjectMapper objectMapper;
	
	
	@BeforeEach
	void cadastrarProdutos() {
		produtoRepository.deleteAll();

		List<Produto> produtos = Arrays.asList(new Produto(null, "Produto 1", Amount.fromNullable(100.0).value()),
				new Produto(null, "Produto 2", Amount.fromNullable(200.0).value()),
				new Produto(null, "Produto 3", Amount.fromNullable(300.0).value()));

		produtoRepository.saveAll(produtos);
	}

}
