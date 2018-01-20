package padroes.templatemethod;

public abstract class TemplateDeImposto implements Imposto {

	//Proibe que as filhas sobrescrevam este metodo
	public final Double calcula(Orcamento orcamento) {
		if(deveUsarMaximaTaxacao(orcamento)){
			return maximaTaxacao(orcamento);
		} else {
			return minimaTaxacao(orcamento);
		}
	}

	public abstract Double minimaTaxacao(Orcamento orcamento);

	public abstract Double maximaTaxacao(Orcamento orcamento);

	public abstract boolean deveUsarMaximaTaxacao(Orcamento orcamento);

}
