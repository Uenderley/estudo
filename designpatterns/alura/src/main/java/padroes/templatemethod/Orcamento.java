package padroes.templatemethod;

public class Orcamento {
	private final Double valor;
	private final Boolean repassaAUniao;

	public Orcamento(Double valor, Boolean repassaAUniao) {
		this.valor = valor;
		this.repassaAUniao = repassaAUniao;
	}

	public Double getValor() {
		return valor;
	}

	public Boolean getRepassaAUniao() {
		return repassaAUniao;
	}
}
