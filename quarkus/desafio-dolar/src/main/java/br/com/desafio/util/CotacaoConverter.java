package br.com.desafio.util;

import java.sql.Timestamp;
import java.time.LocalDate;

import br.com.desafio.model.Cotacao;
import br.com.desafio.model.CotacaoBancoCentral;

public class CotacaoConverter {
	public static Cotacao convert(CotacaoBancoCentral cotacaoBancoCentral) {
		Cotacao cotacao = new Cotacao();
		cotacao.setCompra(cotacaoBancoCentral.getCotacaoCompra());
		cotacao.setVenda(cotacaoBancoCentral.getCotacaoVenda());
		cotacao.setDtCotacaoDolar(cotacaoBancoCentral.getDataHoraCotacao());
		cotacao.setData(LocalDate.now().toString());

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        cotacao.setTimestamp(timestamp.toString());
        
        return cotacao;
	}
}
