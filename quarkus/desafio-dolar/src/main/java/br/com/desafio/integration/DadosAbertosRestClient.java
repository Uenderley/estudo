package br.com.desafio.integration;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/v1")
@RegisterRestClient(configKey="dados-abertos-api")
public interface DadosAbertosRestClient {
	
	@GET
    @Path("/odata/CotacaoDolarPeriodo(dataInicial=@dataInicial,dataFinalCotacao=@dataFinalCotacao)")
    @Produces("application/json")
    String getByDataInicialEDataFinalCotacao(@QueryParam(value = "@dataInicial") String dataInicial,
    									@QueryParam(value = "@dataFinalCotacao") String dataFinalCotacao);
	
	@GET
    @Path("/odata/CotacaoDolarDia(dataCotacao=@dataCotacao)")
    @Produces("application/json")
    String getByData(@QueryParam(value = "@dataCotacao") String data);
}