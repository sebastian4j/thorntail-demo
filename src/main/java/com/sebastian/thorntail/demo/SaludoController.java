package com.sebastian.thorntail.demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author sebastian
 */
@Path("/")
public class SaludoController {
    @GET
    @Path("/bienvenido/{cliente}")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje saludar(@PathParam("cliente") final String cliente) {
        return new Mensaje("hola " + cliente + "!");
    }
}
