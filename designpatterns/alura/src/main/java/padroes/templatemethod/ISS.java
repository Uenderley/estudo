package padroes.templatemethod;

public class ISS implements Imposto{

	public Double calcula(Orcamento orcamento){
		return orcamento.getValor() * 0.06;
	}
	
}
