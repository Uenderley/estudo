package padroes.chainofreponsibility;

import org.junit.Test;

import org.junit.Assert;
import padroes.chainofresponsibility.CalculadorDeDesconto;
import padroes.chainofresponsibility.Item;
import padroes.chainofresponsibility.Orcamento;

public class CalculadorDesconto {

	CalculadorDeDesconto calculador = new CalculadorDeDesconto();
	
	@Test
	public void testarSemDesconto() {
		Orcamento orcamento = new Orcamento(500.0);
		orcamento.adicionaItem(new Item ("Caneta", 250.0));
		orcamento.adicionaItem(new Item ("Caneta", 500.0));
		
		Double calculo = calculador.calcula(orcamento);
		
		Assert.assertEquals(new Double(0), calculo);
	}
	
	@Test
	public void testarDescontoDeQuinhentosReais() {
		Orcamento orcamento = new Orcamento(510.0);
		orcamento.adicionaItem(new Item ("Caneta", 250.0));
		orcamento.adicionaItem(new Item ("Caneta", 500.0));
		
		Double calculo = calculador.calcula(orcamento);
		
		Assert.assertEquals(new Double(35.7), calculo);
	}
	
	@Test
	public void testarDescontoDeCincoItens() {
		Orcamento orcamento = new Orcamento(500.0);
		orcamento.adicionaItem(new Item ("Caneta", 250.0));
		orcamento.adicionaItem(new Item ("Lapis", 500.0));
		orcamento.adicionaItem(new Item ("Borracha", 500.0));
		orcamento.adicionaItem(new Item ("Pincel", 500.0));
		orcamento.adicionaItem(new Item ("Papel", 500.0));
		orcamento.adicionaItem(new Item ("Grafite", 500.0));
		
		Double calculo = calculador.calcula(orcamento);
		
		Assert.assertEquals(new Double(50), calculo);
	}

}
