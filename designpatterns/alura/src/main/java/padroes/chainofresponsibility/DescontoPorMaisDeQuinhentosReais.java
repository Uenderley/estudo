package padroes.chainofresponsibility;

public class DescontoPorMaisDeQuinhentosReais implements Desconto {
	private Desconto proximo;

	public Double desconta(Orcamento orcamento){
		if(orcamento.getValor() > 500.0){
			return orcamento.getValor() * 0.07;
		}
		return proximo.desconta(orcamento);
	}

	public void proximo(Desconto proximo) {
		this.proximo = proximo;
	}
}
