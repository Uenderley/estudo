package com.uenderley;

import io.vertx.core.Future;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.client.HttpResponse;
import io.vertx.ext.web.client.WebClient;
import jakarta.enterprise.context.ApplicationScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;

@ApplicationScoped
public class RouterProxyResource {

    private static final Logger logger = LoggerFactory.getLogger(RouterProxyResource.class);
    private static final String MIME_TYPE = "application/json; application/x-www-form-urlencoded";

    public void proxy(RoutingContext rc, WebClient webClient, String dns) {
        getUpstreamResponse(rc, webClient, dns).onSuccess(upstreamResponse -> {
            rc.response().headers().addAll(upstreamResponse.headers());
            rc.response().setStatusCode(upstreamResponse.statusCode()).end(upstreamResponse.bodyAsBuffer());
            logger.info("Sucesso na resposta");
        }).onFailure(error -> {
            logger.error("Erro na chamada ao parceiro", error);
            rc.response().setStatusCode(502).end(error.getMessage());
        });
    }

    private Future<HttpResponse<Buffer>> getUpstreamResponse(RoutingContext context, WebClient webClient, String dns) {
        URI uri = URI.create(context.request().uri().replace("/api/","/"));
        final var request = webClient.request(
                        HttpMethod.valueOf(context.request().method().name()),
                        443,
                        dns,
                        String.format("%s?%s", uri.getPath(), uri.getQuery()))
                .ssl(true);
                //.putHeaders(context.request().headers());
        logger.debug("Invocation. Method: {}; URL: {}.", context.request().method().name(), uri);
        if (!context.body().isEmpty()){
            return request.sendBuffer(context.body().buffer());
        }
        return request.send();
    }
}
