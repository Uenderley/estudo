package padroes.templatemethod;

public class ICPP extends TemplateDeImposto{

	@Override
	public Double minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.06;
	}

	@Override
	public Double maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.08;
	}

	@Override
	public boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
		return orcamento.getRepassaAUniao();
	}
}
