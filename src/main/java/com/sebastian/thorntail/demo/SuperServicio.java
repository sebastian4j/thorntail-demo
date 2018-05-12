package com.sebastian.thorntail.demo;

import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author sebastian
 */
@ApplicationScoped
public class SuperServicio implements Servicio {
    @Override
    public String servir() {
        return "servicio ejecutado";
    }
}
