package br.com.caixavidaeprevidencia.desafio.caixa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caixavidaeprevidencia.desafio.caixa.commands.ProdutoCommand;
import br.com.caixavidaeprevidencia.desafio.caixa.entities.Produto;
import br.com.caixavidaeprevidencia.desafio.caixa.exceptions.CaixaException;
import br.com.caixavidaeprevidencia.desafio.caixa.exceptions.SemResultadoException;
import br.com.caixavidaeprevidencia.desafio.caixa.exceptions.ValidacaoException;
import br.com.caixavidaeprevidencia.desafio.caixa.repositories.ProdutoRepository;
import br.com.caixavidaeprevidencia.desafio.caixa.util.math.Amount;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public void validarProduto(ProdutoCommand produtoCommand) throws CaixaException {
		validarDescricaoProduto(produtoCommand.getDescricao());
		validarPreco(produtoCommand.getPreco());
	}

	private void validarPreco(Double preco) throws ValidacaoException {
		if (preco == null || preco.compareTo(0.0) <= 0) {
			throw new ValidacaoException("Preço inválido");
		}
	}

	private void validarDescricaoProduto(String descricao) throws CaixaException {
		if (descricao == null || descricao.length() == 0) {
			throw new ValidacaoException("Descrição inválida");
		}
	}

	public Produto salvarProduto(ProdutoCommand produtoCommand) {
		Produto produto = buildProduto(produtoCommand);
		return produtoRepository.save(produto);
	}

	private Produto buildProduto(ProdutoCommand produtoCommand) {
		return Produto.builder() //
				.descricao(produtoCommand.getDescricao()).preco(Amount.fromNullable(produtoCommand.getPreco()).value())
				.build();
	}

	public List<Produto> listarProdutos() {
		return produtoRepository.findAll();
	}

	public Produto pesquisarProdutoPorId(Long idProduto) throws CaixaException  {
		return produtoRepository.findById(idProduto)
				.orElseThrow(()  -> new SemResultadoException("Não existe produto com id: " + idProduto));
	}

}
