package com.uenderley;

import java.util.Arrays;
import java.util.HashSet;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.jwt.JsonWebToken;

import io.smallrye.jwt.auth.principal.JWTParser;
import io.smallrye.jwt.auth.principal.ParseException;
import io.smallrye.jwt.build.Jwt;

@Path("/secured")
@RequestScoped
public class TokenSecuredResource {

    @Inject
    JsonWebToken jwt;

    @Inject
    JWTParser parser;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String generate() {
        return Jwt.issuer("https://example.com/issuer").upn("jdoe@quarkus.io")
                .groups(new HashSet<>(Arrays.asList("User", "Admin"))).claim("name1", "value1").claim("name2", "value2")
                .claim("name3", "value3").sign();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@QueryParam(value = "token") String token) {
        JsonWebToken jwt = null;
        try {
            jwt = parser.parse(token);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

}
