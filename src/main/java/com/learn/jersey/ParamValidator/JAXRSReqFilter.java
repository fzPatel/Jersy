package com.learn.jersey.ParamValidator;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@QueryParamValidator
public class JAXRSReqFilter implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        MultivaluedMap < String, String > queryParameters = requestContext.getUriInfo().getQueryParameters();
        String queryParam = queryParameters.keySet().stream().findFirst().get();
        System.out.println("Query param - " + queryParam);
        if (!queryParam.equals("p")) {
            requestContext.abortWith(Response
                .status(Response.Status.BAD_REQUEST)
                .entity("Invalid Query Param " + queryParam)
                .build());
        }
    }
}