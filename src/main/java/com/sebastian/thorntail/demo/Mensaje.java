package com.sebastian.thorntail.demo;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 *
 * @author sebastian
 */
@Schema(name="Mensaje", description="Mensaje enviado al cliente.")
public class Mensaje {
    public String mensaje;
    public Mensaje() {        
    }
    public Mensaje(String m) {
        this.mensaje = m;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
