package com.uenderley;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.eatthepath.otp.TimeBasedOneTimePasswordGenerator;

import org.apache.commons.lang3.StringUtils;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/otpReceiver")
public class ReceiverResource {

    @ConfigProperty(name = "otp.codigo")
    String otpCodigo;

    @GET
    @Path("/validarToken")
    @Produces(MediaType.TEXT_PLAIN)
    public boolean token(@QueryParam(value = "codigo") String codigo) {
        String codigoGerado = gerarToken();
        return codigo.equals(codigoGerado);
    }

    @GET
    @Path("/tokenValidate")
    @Produces(MediaType.TEXT_PLAIN)
    public String tokenValidate(@QueryParam("otp") String codigo, @QueryParam("nome") String nome) {
        String codigoGerado = gerarToken();
        if(codigo.equals(codigoGerado)){
            return nome + ", você pode acessar o serviço.";
        }
        return nome + ", você precisa digitar um código válido.";
    }

    private String gerarToken() {
        SecretKey key = new SecretKeySpec(otpCodigo.getBytes(), "SHA1");
        try {
            Date date = new Date();
            
            //date.setDate(date.getDate() + 1);

            TimeBasedOneTimePasswordGenerator otpGenerator = new TimeBasedOneTimePasswordGenerator(30, TimeUnit.SECONDS, 6, "HmacSHA1");
            return StringUtils.leftPad(otpGenerator.generateOneTimePassword(key, date) + "", 6, '0');
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }

}