package br.com.desafio.resource;

import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.desafio.integration.DadosAbertosService;
import br.com.desafio.model.CotacaoBancoCentral;
import io.quarkus.test.junit.QuarkusTest;

//@QuarkusTest
public class DadosAbertosServiceTest {
	
	//@Inject
	private DadosAbertosService dadosAbertosService;
	
	//@Test
	public void testConsultarDadosAbertosPorPeriodoEndpoint() {
		Assertions.assertNotNull(dadosAbertosService.obterCotacoes("'02-02-2020'", "'02-06-2020'"));
	}
	
	//@Test
	public void testConsultarDadosAbertosDataCertaEndpoint() {
		//Assertions.assertNotNull(dadosAbertosService.obter("'02-02-2020'"));
	}
	
	//@Test
	public void testConsultarDadosAbertosComVerificacaoDeValor() {
		List<CotacaoBancoCentral> cotacoes = dadosAbertosService.obterCotacoes("'02-02-2020'", "'02-06-2020'");
		
		cotacoes.forEach(cotacao -> {
			System.out.print(" Cotacao ----- " +cotacao.getDataHoraCotacao());
			System.out.print(" Compra ----- " +cotacao.getCotacaoCompra());
			System.out.print(" Venda ----- " +cotacao.getCotacaoVenda());
		});
	}
	
}