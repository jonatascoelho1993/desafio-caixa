package br.com.caixavidaeprevidencia.desafio.caixa.facades;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.caixavidaeprevidencia.desafio.caixa.commands.ProdutoCommand;
import br.com.caixavidaeprevidencia.desafio.caixa.entities.Produto;
import br.com.caixavidaeprevidencia.desafio.caixa.exceptions.CaixaException;
import br.com.caixavidaeprevidencia.desafio.caixa.services.ProdutoService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProdutoFacade {

	@Autowired
	private ProdutoService produtoService;

	@Transactional(rollbackFor = Exception.class)
	public Produto criarProduto(ProdutoCommand produtoCommand) throws CaixaException {
		log.info("Cadastrando o produto: {}", produtoCommand);
		produtoService.validarProduto(produtoCommand);
		return produtoService.salvarProduto(produtoCommand);
	}

	public List<Produto> listarProdutos() {
		return produtoService.listarProdutos();
	}

	public Produto pesquisarProdutoPorId(Long idProduto) throws CaixaException {
		return produtoService.pesquisarProdutoPorId(idProduto);
	}

}
