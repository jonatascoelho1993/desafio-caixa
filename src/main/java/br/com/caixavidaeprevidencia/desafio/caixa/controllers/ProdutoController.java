package br.com.caixavidaeprevidencia.desafio.caixa.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.caixavidaeprevidencia.desafio.caixa.dtos.ProdutoDTO;
import br.com.caixavidaeprevidencia.desafio.caixa.dtos.ProdutoRequestDTO;



@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	
	@GetMapping
	public List<ProdutoDTO> getAll(){
		return Arrays.asList(new ProdutoDTO());
	}
	
	@GetMapping("/{idProduto}")
	public ProdutoDTO getProdutoById(@PathVariable Long idProduto) {
		return new ProdutoDTO();
	}
	
	@PostMapping
	public ProdutoDTO postProduto(@RequestBody ProdutoRequestDTO request) {
		return new ProdutoDTO();
	}

}
