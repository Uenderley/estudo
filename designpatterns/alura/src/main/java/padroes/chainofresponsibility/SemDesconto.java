package padroes.chainofresponsibility;

public class SemDesconto implements Desconto {
	
	public Double desconta(Orcamento orcamento){
		return 0.0;
	}
	
	public void proximo(Desconto proximo) {
		
	}
}
