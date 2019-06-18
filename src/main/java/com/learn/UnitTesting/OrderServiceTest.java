package com.learn.UnitTesting;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.junit.Assert;
import org.junit.Test;
import org.glassfish.jersey.test.JerseyTest;


import com.learn.jersy.MyFirstJersy.MyResource;

public class OrderServiceTest extends MyResource {
  
	  protected Application configure() {
	        return new ResourceConfig(MyResource.class);
	    }
	  MyResource myResource=new MyResource();
	@Test
    public String secured() {
        String response = myResource.secured().get(String.class);
        Assert.assertTrue("This api is Secured	".equals(response));
    }

    
	
	
    @Test
    public void ordersPathParamTest() {
        String response = target("orders/453").request().get(String.class);
        Assert.assertTrue("orderId: 453".equals(response));
    }

    
    
    @Test
    public void ordersFixedPathTest() {
        String response = target("orders/summary").request().get(String.class);
        Assert.assertTrue("orders summary".equals(response));
    }
}