package com.sebastian.thorntail.demo;

import io.thorntail.test.ThorntailTestRunner;
import javax.inject.Inject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * testing con thorntail.
 * @author sebastian
 */
@RunWith(ThorntailTestRunner.class)
public class ThorntailDemoTest {
    @Inject
    private Servicio servicio;
    
    @Test
    public void thornTest() {
        Assert.assertNotNull(servicio);        
        Assert.assertEquals("servicio ejecutado", servicio.servir());        
    }
}
