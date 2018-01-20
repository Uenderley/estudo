package padroes.templatemethod;

public class ICVK extends TemplateDeImposto{
	
	@Override
	public Double minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.067;
	}

	@Override
	public Double maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.098;
	}

	@Override
	public boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
		return orcamento.getRepassaAUniao() && orcamento.getValor() > 50;
	}
	
}
