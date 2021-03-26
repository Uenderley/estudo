package com.uenderley;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.eatthepath.otp.TimeBasedOneTimePasswordGenerator;
import com.uenderley.service.OtpService;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/otpSender")
public class SenderResource {

    @ConfigProperty(name = "otp.codigo")
    String otpCodigo;

    @Inject
    @RestClient
    OtpService otpService;

    @GET
    @Path("/gerarToken")
    @Produces(MediaType.TEXT_PLAIN)
    public String token() {
        return gerarToken();
    }

    @GET
    @Path("/acessarServico")
    @Produces(MediaType.TEXT_PLAIN)
    public String acessarServico(@QueryParam(value = "nome") String nome) {
        return otpService.acessar(gerarToken(), nome);
    }

    @GET
    @Path("/gerarCodigoPareamento")
    @Produces(MediaType.TEXT_PLAIN)
    public String gerarCodigoPareamento(@QueryParam(value = "valor") String valor) {
        return Base64.getEncoder().encodeToString(valor.getBytes());
    }

    @GET
    @Path("/converterCodigoPareamento")
    @Produces(MediaType.TEXT_PLAIN)
    public String converterCodigoPareamento(@QueryParam(value = "valor") String valor) {
        byte[] decodedBytes = Base64.getDecoder().decode(valor);
        return new String(decodedBytes);
    }
    
    private String gerarToken() {
        SecretKey key = new SecretKeySpec(otpCodigo.getBytes(), "SHA1");
        try {
            TimeBasedOneTimePasswordGenerator otpGenerator = new TimeBasedOneTimePasswordGenerator(30, TimeUnit.SECONDS, 6, "HmacSHA1");
            return StringUtils.leftPad(otpGenerator.generateOneTimePassword(key, new Date()) + "", 6, '0');
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }
}