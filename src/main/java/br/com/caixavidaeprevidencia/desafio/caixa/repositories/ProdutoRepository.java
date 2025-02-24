package br.com.caixavidaeprevidencia.desafio.caixa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caixavidaeprevidencia.desafio.caixa.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
