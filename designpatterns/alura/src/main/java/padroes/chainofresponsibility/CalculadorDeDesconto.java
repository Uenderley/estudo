package padroes.chainofresponsibility;

public class CalculadorDeDesconto {
	public Double calcula(Orcamento orcamento){
		Desconto descontoCincoIntens = new DescontoPorCincoItens();
		Desconto descontoQuinhentosReais = new DescontoPorMaisDeQuinhentosReais();
		Desconto sem = new SemDesconto();
		
		descontoCincoIntens.proximo(descontoQuinhentosReais);
		descontoQuinhentosReais.proximo(sem);
		
		return descontoCincoIntens.desconta(orcamento);
	}
}
