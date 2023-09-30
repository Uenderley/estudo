package com.uenderley;

import io.quarkus.vertx.web.Route;
import io.vertx.core.Vertx;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.client.WebClient;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class OtherResource {

    @Inject
    RouterProxyResource routerProxyResource;

    private final WebClient client;

    @Inject
    public OtherResource(Vertx vertx) {
        this.client = WebClient.create(vertx);
    }

    @PreDestroy
    public void clean() {
        this.client.close();
    }

    @Route(path = "/ready", order = 1)
    @Route(path = "/health", order = 1)
    public String health() {
        return "tudo health!!";
    }

    @Route(path = "/api/*", order = 2)
    public void proxyRouter(RoutingContext rc) {
        routerProxyResource.proxy(rc, client, "jsonplaceholder.typicode.com");
    }
}
