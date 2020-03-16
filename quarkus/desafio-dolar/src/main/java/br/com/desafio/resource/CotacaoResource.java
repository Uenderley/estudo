package br.com.desafio.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.opentracing.Traced;

import br.com.desafio.exception.APIIntegrationException;
import br.com.desafio.model.Cotacao;
import br.com.desafio.service.CotacaoService;
import br.com.desafio.util.DateValidatorUsingDateFormat;

@Traced
@Path("/cotacoes")
public class CotacaoResource {
	@Inject CotacaoService cotacaoService;
	
	@GET
	@Path("/consultarTodas")
	@Operation(
	        summary = "Consulta todas as cotações armazenadas.",
	        description = "Irá consultar todas as cotações já consultadas e armazenadas anteriormente.")
	@Produces(MediaType.APPLICATION_JSON)
    public Response listar() {
		List<Cotacao> cotacoes = cotacaoService.listar();

		if(cotacoes != null) {
			Response.ok("Não há dados a serem consultados.");
		}
		return Response.ok(cotacoes).build();
    }
	
	@GET
	@Path("/consultar/{data}")
	@Operation(
	        summary = "Consulta a cotação em um dia específico.",
	        description = "Irá consultar e retornar a cotação em determinado dia. O formato padrão é MM-DD-YYYY")
	@Produces(MediaType.APPLICATION_JSON)
    public Response listar(@PathParam(value = "data") String data) {
		Response response = null;
		
		if(!DateValidatorUsingDateFormat.isValid(data)) {
			return Response.ok("Data no formato inválido. Ex MM-dd-YYYY").build();
		}
		
		try {
			Cotacao cotacao = cotacaoService.listar(data);
			response = Response.ok(cotacao).build();
		} catch (APIIntegrationException e) {
			response = Response.ok("Erro ao consultar a API").build();
		}
		return response;
    }
	
	@GET
	@Path("/consultarPeriodo/{dataInicial}/{dataFinal}")
	@Operation(
	        summary = "Consulta cotações em um determinado período.",
	        description = "Irá consultar e retornar as cotações por um determinado período. O formato padrão é MM-DD-YYYY")
	@Produces(MediaType.APPLICATION_JSON)
    public Response listaPorPeriodo(@PathParam(value = "dataInicial") String dataInicial, 
    									 @PathParam(value = "dataFinal") String dataFinal) {
		Response response = null;
		
		if(!DateValidatorUsingDateFormat.isValid(dataInicial) || 
				!DateValidatorUsingDateFormat.isValid(dataFinal)) {
			return Response.ok("Data no formato inválido. Ex MM-dd-YYYY").build();
		}
		
		try {
			List<Cotacao> cotacoes = cotacaoService.listar(dataInicial, dataFinal);
			if(cotacoes != null && cotacoes.isEmpty()) {
				response = Response.ok("Não há dados a serem consultados.").build();
			} else {
				response = Response.ok(cotacoes).build();
			}
		} catch (APIIntegrationException e) {
			response = Response.ok("Erro ao consultar a API").build();
		}
		return response;
    }
	
	@DELETE
	@Path("/apagarBase")
	@Operation(summary = "Apaga toda a base de dados de cotações.")
	@Produces(MediaType.TEXT_PLAIN)
	public String apagar() {
		cotacaoService.apagarBase();
		return "Dados apagados com sucesso";
	}
}
