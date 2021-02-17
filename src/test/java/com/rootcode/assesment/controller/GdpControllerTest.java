package com.rootcode.assesment.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rootcode.assesment.gdp.controller.GdpController;
import com.rootcode.assesment.gdp.service.GdpService;

/**
 * Test class for User controller
 * 
 * @author lahirua
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class GdpControllerTest {

    @InjectMocks
    private GdpController gdpController;
    
    @Mock
    private GdpService gdpService;

    @Test
    public void testgetGdpRate() {
	
	String rate = "123";
	
	Mockito.when(gdpService.getGdpRate(Mockito.anyString(), Mockito.anyString())).thenReturn(rate);
	
	String result = gdpController.getGdpRate("AFG", "2010");
	
	Assert.assertNotNull(result);
	Assert.assertEquals(rate, result);
    }

}
