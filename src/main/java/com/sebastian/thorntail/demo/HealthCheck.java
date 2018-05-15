package com.sebastian.thorntail.demo;

import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheckResponse;

/**
 * servicio de status.
 *
 * @author sebastian
 */
@Health
@ApplicationScoped
public class HealthCheck implements org.eclipse.microprofile.health.HealthCheck {

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.named("DemoHealth").withData("a", "b")
                .up().build();
    }

}
