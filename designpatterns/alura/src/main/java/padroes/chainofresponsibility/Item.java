package padroes.chainofresponsibility;

public class Item {
	private final String nome;
	private final Double valor;

	public Item(String nome, Double valor) {
		this.nome = nome;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public Double getValor() {
		return valor;
	}
}
