package padroes.templatemethod;

public class ICMS implements Imposto{
	
	public Double calcula(Orcamento orcamento){
		return orcamento.getValor() * 0.10;
	}
	
}
