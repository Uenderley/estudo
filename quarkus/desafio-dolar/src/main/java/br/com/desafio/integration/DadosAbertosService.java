package br.com.desafio.integration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import br.com.desafio.model.CotacaoBancoCentral;

@ApplicationScoped
public class DadosAbertosService {
	
	@Inject
    @RestClient
    DadosAbertosRestClient dadosAbertosRestClient;
	
    private final Logger log = LoggerFactory.getLogger(DadosAbertosService.class);

	/**
	 * Metodo que vai na api do banco central consultar por um determinado periodo
	 * OBS: deve ser passado usando aspas simples dentro da string
	 * @param dataInicial '02-02-2020'
	 * @param dataFinal '02-06-2020'
	 * @return Cotacoes
	 */
	public List<CotacaoBancoCentral> obterCotacoes(String dataInicial, String dataFinal){
		log.info("Iniciando consulta a API do banco central para periodos");
		
		List<CotacaoBancoCentral> cotacoesBancoCentral = new ArrayList<>();
		
		String dados = dadosAbertosRestClient.getByDataInicialEDataFinalCotacao(dataInicial, dataFinal);
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			final ObjectNode node = new ObjectMapper().readValue(dados, ObjectNode.class);
			node.remove("@odata.context");
			node.arrayNode();
			
			String valores = node.get("value").toString();

			cotacoesBancoCentral = Arrays.asList(mapper.readValue(valores, CotacaoBancoCentral[].class));
		} catch (JsonMappingException e1) {
			e1.printStackTrace();
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}
		return cotacoesBancoCentral;
	}
	
	/**
	 * Metodo que vai na api do banco central consultar a cotacao em um determinado dia.
	 * OBS: deve ser passado usando aspas simples dentro da string
	 * @param data '02-02-2020'
	 * @return Cotação
	 */
	public CotacaoBancoCentral obter(String data){
		log.info("Iniciando consulta a API do banco central em uma data");
		
		CotacaoBancoCentral cotacao = new CotacaoBancoCentral();
		
		String dados = dadosAbertosRestClient.getByData(data);
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			final ObjectNode node = new ObjectMapper().readValue(dados, ObjectNode.class);
			node.remove("@odata.context");
			node.arrayNode();
			String valor = node.get("value").toString();
			CotacaoBancoCentral[] readValue = mapper.readValue(valor, CotacaoBancoCentral[].class);
			cotacao = readValue[0];
		} catch (JsonMappingException e1) {
			e1.printStackTrace();
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}
		return cotacao;
	}
}