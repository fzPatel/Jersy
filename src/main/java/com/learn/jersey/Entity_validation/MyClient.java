package com.learn.jersey.Entity_validation;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class MyClient {

    public static void main(String[] args) throws Exception {
        Customer customer = new Customer();
        customer.setName(null);
        customer.setAddress(null);
        customer.setPhoneNumber("343-343-343");

        Client client = ClientBuilder.newBuilder().build();
        WebTarget target =
                client.target("http://localhost:8080/MyFirstJersy/webapi/myresource/customers");
        Response response = target.request()
                                .post(Entity.entity(customer,
                                        MediaType.TEXT_XML), Response.class);
        System.out.println(response.readEntity(String.class));
    }
}