package br.com.desafio.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.opentracing.Traced;

import br.com.desafio.model.Cotacao;
import br.com.desafio.service.CotacaoService;

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
    public List<Cotacao> listar() {
        return cotacaoService.listar();
    }
	
	@GET
	@Path("/consultar/{data}")
	@Operation(
	        summary = "Consulta a cotação em um dia específico.",
	        description = "Irá consultar e retornar as cotações por um determinado período.")
	@Produces(MediaType.APPLICATION_JSON)
    public Cotacao listar(@PathParam(value = "data") String data) {
        return cotacaoService.listar(data);
    }
	
	@GET
	@Path("/consultarPeriodo/{dataInicial}/{dataFinal}")
	@Operation(
	        summary = "Consulta cotações em um determinado período.",
	        description = "Irá consultar e retornar as cotações por um determinado período.")
	@Produces(MediaType.APPLICATION_JSON)
    public List<Cotacao> listaPorPeriodo(@PathParam(value = "dataInicial") String dataInicial, 
    									 @PathParam(value = "dataFinal") String dataFinal) {
        return cotacaoService.listar(dataInicial, dataFinal);
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
