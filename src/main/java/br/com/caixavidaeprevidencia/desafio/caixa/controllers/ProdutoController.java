package br.com.caixavidaeprevidencia.desafio.caixa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.caixavidaeprevidencia.desafio.caixa.builders.ProdutoCommandBuilder;
import br.com.caixavidaeprevidencia.desafio.caixa.builders.ProdutoDTOBuilder;
import br.com.caixavidaeprevidencia.desafio.caixa.dtos.ProdutoDTO;
import br.com.caixavidaeprevidencia.desafio.caixa.dtos.ProdutoRequestDTO;
import br.com.caixavidaeprevidencia.desafio.caixa.entities.Produto;
import br.com.caixavidaeprevidencia.desafio.caixa.exceptions.CaixaException;
import br.com.caixavidaeprevidencia.desafio.caixa.facades.ProdutoFacade;



@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoFacade produtoFacade;
	
	@GetMapping
	public List<ProdutoDTO> getAll(){
		return ProdutoDTOBuilder.build(produtoFacade.listarProdutos());
	}
	
	@GetMapping("/{idProduto}")
	public ProdutoDTO getProdutoById(@PathVariable Long idProduto) throws CaixaException {
		return ProdutoDTOBuilder.build(produtoFacade.pesquisarProdutoPorId(idProduto));
	}
	
	@PostMapping
	public ProdutoDTO postProduto(@RequestBody ProdutoRequestDTO request) throws CaixaException {
		Produto produto = produtoFacade.criarProduto(ProdutoCommandBuilder.build(request));
		return ProdutoDTOBuilder.build(produto);
	}

}
