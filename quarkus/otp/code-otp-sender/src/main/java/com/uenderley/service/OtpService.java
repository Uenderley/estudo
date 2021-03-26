package com.uenderley.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import org.jboss.resteasy.annotations.jaxrs.QueryParam;

@Path("/otpReceiver")
@RegisterRestClient(configKey = "otp-service-key")
public interface OtpService {
    
    @GET
    @Path("/tokenValidate")
    @Produces(MediaType.TEXT_PLAIN)
    public String acessar(@QueryParam("otp") String codigoOtp, @QueryParam("nome") String nome);
}
