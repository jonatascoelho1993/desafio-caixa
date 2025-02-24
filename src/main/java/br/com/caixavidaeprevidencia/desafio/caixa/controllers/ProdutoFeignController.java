package br.com.caixavidaeprevidencia.desafio.caixa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.caixavidaeprevidencia.desafio.caixa.api.ProdutoControllerApiClient;
import br.com.caixavidaeprevidencia.desafio.caixa.dtos.IdProdutoRequestDTO;
import br.com.caixavidaeprevidencia.desafio.caixa.exceptions.CaixaException;



@RestController
@RequestMapping("/api/produto")
public class ProdutoFeignController {
	
	@Autowired
	private ProdutoControllerApiClient produtoClient;
	

	@PostMapping
	public ResponseEntity<?> getProdutoById(@RequestBody IdProdutoRequestDTO request) throws CaixaException {
		return produtoClient.getProdutoById(request.getId());
	}

}
