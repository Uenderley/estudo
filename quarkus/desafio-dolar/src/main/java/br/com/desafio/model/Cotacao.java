package br.com.desafio.model;

public class Cotacao {

	private String _id;
	private String timestamp;
	private String dtCotacaoDolar;
	private Double compra;
	private Double venda;
	private String data;

	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getDtCotacaoDolar() {
		return dtCotacaoDolar;
	}
	public void setDtCotacaoDolar(String dtCotacaoDolar) {
		this.dtCotacaoDolar = dtCotacaoDolar;
	}
	public Double getCompra() {
		return compra;
	}
	public void setCompra(Double compra) {
		this.compra = compra;
	}
	public Double getVenda() {
		return venda;
	}
	public void setVenda(Double venda) {
		this.venda = venda;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
