package br.com.desafio.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.bson.Document;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.opentracing.Traced;
import org.mongojack.JacksonMongoCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import br.com.desafio.exception.APIIntegrationException;
import br.com.desafio.integration.DadosAbertosService;
import br.com.desafio.model.Cotacao;
import br.com.desafio.model.CotacaoBancoCentral;
import br.com.desafio.util.CotacaoConverter;

@Traced
@ApplicationScoped
public class CotacaoService {
	@Inject
    MongoClient mongoClient;
	
	@Inject
	DadosAbertosService dadosAbertosService;
	
    private final Logger log = LoggerFactory.getLogger(CotacaoService.class);

    @Counted(name = "contador listar todos")
	public List<Cotacao> listar(){
		List<Cotacao> cotacoes = new ArrayList<>();
		
		JacksonMongoCollection<Cotacao> jacksonMongoCollection = JacksonMongoCollection
				.builder().build(mongoClient, "desafio", "cotacao", Cotacao.class);
		
		MongoCursor<Cotacao> cursor = jacksonMongoCollection.find().iterator();
		try {
            while (cursor.hasNext()) {
            	cotacoes.add(cursor.next());
            }
        } finally {
            cursor.close();
        }
        return cotacoes;
	}
	
	@Counted(name = "contador busca por data especifica")
	public Cotacao listar(String data){
		CotacaoBancoCentral cotacaoBancoCentral = null;
		
		try {
			cotacaoBancoCentral = dadosAbertosService.obter(data);
		} catch (Exception e) {
			log.error("Houve um erro ao consultar a API");
			throw new APIIntegrationException(e.getMessage());
		}
		
		Cotacao cotacao = CotacaoConverter.convert(cotacaoBancoCentral);
		salvar(cotacao);
        return cotacao;
	}
	
	@Counted(name = "contador busca por periodo")
	public List<Cotacao> listar(String dataInicio, String dataFim) {
		LocalDateTime dataInicioIntegracao = LocalDateTime.now();
		List<CotacaoBancoCentral> cotacoesBancoCentral = null;
		try {
			cotacoesBancoCentral = dadosAbertosService.obterCotacoes(dataInicio, dataFim);
		}catch (Exception e) {
			log.error("Houve um erro ao consultar a API");
			throw new APIIntegrationException(e.getMessage());
		}
		
		LocalDateTime dataFimIntegracao = LocalDateTime.now();
		Duration duration = Duration.between(dataInicioIntegracao, dataFimIntegracao);
        log.info("A requisição durou " + duration.getNano() + " nano segundos");
		
        List<Cotacao> cotacoes = new ArrayList<>();
        
		cotacoesBancoCentral.forEach(cotacaoBancoCentral -> {
			Cotacao cotacao = CotacaoConverter.convert(cotacaoBancoCentral);
	        cotacoes.add(cotacao);
	        salvar(cotacao);
		});
		
        return cotacoes;
	}
	
	public void salvar(Cotacao cotacao){
        Document document = new Document()
                .append("compra", cotacao.getCompra())
                .append("venda", cotacao.getVenda())
        		.append("timestamp", cotacao.getTimestamp())
        		.append("dtCotacaoDolar", cotacao.getDtCotacaoDolar())
        		.append("data", cotacao.getData());
        getCollection().insertOne(document);
    }
	
	private MongoCollection<Document> getCollection(){
        return mongoClient.getDatabase("desafio").getCollection("cotacao");
    }

	public void apagarBase() {
		BasicDBObject document = new BasicDBObject();
		mongoClient.getDatabase("desafio").getCollection("cotacao").deleteMany(document);
	}
}

