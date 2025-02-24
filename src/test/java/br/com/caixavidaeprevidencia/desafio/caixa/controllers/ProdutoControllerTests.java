package br.com.caixavidaeprevidencia.desafio.caixa.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;

import br.com.caixavidaeprevidencia.desafio.caixa.dtos.ProdutoRequestDTO;
import br.com.caixavidaeprevidencia.desafio.caixa.entities.Produto;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class ProdutoControllerTests extends ProdutoAbstractTests{

	@Test
	void listarTodosOsProdutosSucesso() throws Exception {
		mockMvc.perform(get("/api/produtos")).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(3)))
				.andExpect(jsonPath("$[0].descricao").value("Produto 1"))
				.andExpect(jsonPath("$[1].descricao").value("Produto 2"))
				.andExpect(jsonPath("$[2].descricao").value("Produto 3"));
	}

	@Test
	void pesquisarProdutoPorIdSucesso() throws Exception {
		Produto produto = produtoRepository.findAll().get(0);

		mockMvc.perform(get("/api/produtos/{id}", produto.getIdProduto())).andExpect(status().isOk())
				.andExpect(jsonPath("$.descricao").value(produto.getDescricao()))
				.andExpect(jsonPath("$.preco").value(produto.getPreco()));
	}

	@Test
	void pesquisarProdutoPorIdProdutoNaoEncontrado() throws Exception {
		mockMvc.perform(get("/api/produtos/{id}", 999)).andExpect(status().isNotFound())
				.andExpect(content().string("Não existe produto com id: 999"));
	}

	@Test
	void cadastrarProdutoSucesso() throws Exception {
		ProdutoRequestDTO novoProduto = new ProdutoRequestDTO("Novo Produto", 150.0);

		mockMvc.perform(post("/api/produtos").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(novoProduto))).andExpect(status().isOk())
				.andExpect(jsonPath("$.descricao").value("Novo Produto")).andExpect(jsonPath("$.preco").value(150.0));

		assertThat(produtoRepository.findAll()).hasSize(4);
	}

	@Test
	void cadastrarProdutoDescricaoInvalida() throws Exception {
		ProdutoRequestDTO produtoInvalido = new ProdutoRequestDTO("", 100.0);

		mockMvc.perform(post("/api/produtos").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(produtoInvalido))).andExpect(status().isBadRequest())
				.andExpect(content().string("Descrição inválida"));
	}

	@Test
	void cadastrarProdutoPrecoInvalido() throws Exception {
		ProdutoRequestDTO produtoInvalido = new ProdutoRequestDTO("Produto Inválido", -50.0);

		mockMvc.perform(post("/api/produtos").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(produtoInvalido))).andExpect(status().isBadRequest())
				.andExpect(content().string("Preço inválido"));
	}
	
}