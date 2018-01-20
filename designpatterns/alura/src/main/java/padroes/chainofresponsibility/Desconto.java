package padroes.chainofresponsibility;

public interface Desconto {
	Double desconta(Orcamento orcamento);
	void proximo(Desconto proximo);
}
