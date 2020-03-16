package br.com.desafio.resource;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class CotacaoResourceTest {
	
	@Test
	public void testConsultarTodasEndpoint() {
		given().when().get("/cotacoes/consultarTodas").then().statusCode(200);
	}
	
	@Test
	public void testConsultarPeriodoEndpoint() {
		given().when().get("/cotacoes/consultarPeriodo/'02-02-2020'/'02-06-2020'").then().statusCode(200);
	}
	
	@Test
	public void testConsultarEndpoint() {
		given().when().get("/cotacoes/consultar/'02-02-2020'").then().statusCode(200);
	}

}