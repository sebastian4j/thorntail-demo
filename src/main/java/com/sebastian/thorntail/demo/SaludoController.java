package com.sebastian.thorntail.demo;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

/**
 *
 * @author sebastian
 */
@Path("/")
public class SaludoController {

    @Inject
    private Servicio servicio;

    @GET
    @Path("/bienvenido/{cliente}")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(value = {
        @APIResponse(
                responseCode = "200",
                description = "Saludo al Cliente.",
                content = @Content(
                        mediaType = MediaType.APPLICATION_JSON,
                        schema = @Schema(implementation = Mensaje.class)))})
    @Operation(
            summary = "Obtiene un saludo",
            description = "Genera un saludo personalizado al cliente que realiza el request.")
    public Mensaje saludar(@PathParam("cliente") final String cliente) {
        return new Mensaje(servicio.servir() + " - Hola " + cliente);
    }
}
