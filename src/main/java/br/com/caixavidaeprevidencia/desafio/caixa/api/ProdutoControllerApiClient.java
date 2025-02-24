package br.com.caixavidaeprevidencia.desafio.caixa.api;

import org.springframework.cloud.openfeign.FeignClient;

import br.com.caixavidaeprevidencia.desafio.caixa.config.ClientConfiguration;


@FeignClient(name="${desafioCaixaVidaPrevidencia.name:desafioCaixaVidaPrevidencia}", url="${desafioCaixaVidaPrevidencia.url:http://localhost:8080}", configuration = ClientConfiguration.class)
public interface ProdutoControllerApiClient extends ProdutoControllerApi {
}