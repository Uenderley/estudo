package padroes.strategy;

import org.junit.Assert;
import org.junit.Test;

import padroes.strategy.CalculadorDeImposto;
import padroes.strategy.ICMS;
import padroes.strategy.ISS;
import padroes.strategy.Imposto;
import padroes.strategy.Orcamento;

public class CalculadorTeste {

	CalculadorDeImposto calculador = new CalculadorDeImposto();
	
	@Test
	public void testarCalculoICMS() {
		Imposto imposto = new ICMS();
		Orcamento orcamento = new Orcamento(500.00);
		
		Double calculo = calculador.realizaCalculo(orcamento, imposto);
		
		Assert.assertEquals(new Double(50), calculo);
	}
	
	@Test
	public void testarCalculoISS() {
		Imposto imposto = new ISS();
		Orcamento orcamento = new Orcamento(500.00);
		
		Double calculo = calculador.realizaCalculo(orcamento, imposto);
		
		Assert.assertEquals(new Double(30), calculo);
	}

}
