package padroes.templatemethod;

import org.junit.Assert;import org.junit.Test;

public class CalculadorTeste {

	CalculadorDeImposto calculador = new CalculadorDeImposto();
	
	@Test
	public void testarCalculoICPPMaxima() {
		Imposto imposto = new ICPP();
		Orcamento orcamento = new Orcamento(500.00, true);
		
		Double calculo = calculador.realizaCalculo(orcamento, imposto);

		Assert.assertEquals(new Double(40), calculo);
	}
	
	@Test
	public void testarCalculoICPPMinima() {
		Imposto imposto = new ICPP();
		Orcamento orcamento = new Orcamento(500.00, false);
		
		Double calculo = calculador.realizaCalculo(orcamento, imposto);
		
		Assert.assertEquals(new Double(30), calculo);
	}
	
	@Test
	public void testarCalculoICVKMaxima() {
		Imposto imposto = new ICVK();
		Orcamento orcamento = new Orcamento(500.00, true);
		
		Double calculo = calculador.realizaCalculo(orcamento, imposto);
		
		Assert.assertEquals(new Double(49), calculo);
	}
	
	@Test
	public void testarCalculoICVKMinimaNaoRepassa() {
		Imposto imposto = new ICVK();
		Orcamento orcamento = new Orcamento(500.00, false);
		
		Double calculo = calculador.realizaCalculo(orcamento, imposto);
		
		Assert.assertEquals(new Double(33.5), calculo);
	}

	@Test
	public void testarCalculoICVKMinimaOrcamentoPequeno() {
		Imposto imposto = new ICVK();
		Orcamento orcamento = new Orcamento(49.00, true);
		
		Double calculo = calculador.realizaCalculo(orcamento, imposto);
		
		Assert.assertEquals(new Double(3.2830000000000004), calculo);
	}
	
	@Test
	public void testarCalculoICMS() {
		Imposto imposto = new ICMS();
		Orcamento orcamento = new Orcamento(500.00, false);
		
		Double calculo = calculador.realizaCalculo(orcamento, imposto);
		
		Assert.assertEquals(new Double(50), calculo);
	}
	
	@Test
	public void testarCalculoISS() {
		Imposto imposto = new ISS();
		Orcamento orcamento = new Orcamento(500.00, false);
		
		Double calculo = calculador.realizaCalculo(orcamento, imposto);
		
		Assert.assertEquals(new Double(30), calculo);
	}
}

