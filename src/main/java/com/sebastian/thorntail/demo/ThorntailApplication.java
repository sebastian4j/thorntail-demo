package com.sebastian.thorntail.demo;

import io.thorntail.Thorntail;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * demo utilizando Thorntail.
 * @author sebastian
 */
@ApplicationPath("/")
public class ThorntailApplication extends Application {   
    public static void main(String[] args) throws Exception {
        Thorntail.main(args);
    }
}
