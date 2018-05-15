package com.sebastian.thorntail.demo;

import io.thorntail.Thorntail;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;

/**
 * demo utilizando Thorntail.
 *
 * @author sebastian
 */
@ApplicationPath("/")
@OpenAPIDefinition(info = @Info(
        title = "Thorntail Demo",
        version = "1.0"
))
public class ThorntailApplication extends Application {

    public static void main(String[] args) throws Exception {
        Thorntail.main(args);
    }
}
