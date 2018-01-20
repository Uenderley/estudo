package padroes.strategy;

public class CalculadorDeImposto {

	public Double realizaCalculo(Orcamento orcamento, Imposto imposto){
		return imposto.calcula(orcamento);
	}
}
