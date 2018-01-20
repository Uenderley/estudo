package padroes.chainofresponsibility;

public class DescontoPorCincoItens implements Desconto {
	
	private Desconto proximo;
	
	public Double desconta(Orcamento orcamento){
		if(orcamento.getItens().size() > 5){
			return orcamento.getValor() * 0.1;
		}
		return proximo.desconta(orcamento);
	}
	
	public void proximo(Desconto proximo) {
		this.proximo = proximo;
	}
}
