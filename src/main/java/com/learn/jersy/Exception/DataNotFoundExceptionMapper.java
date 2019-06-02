package com.learn.jersy.Exception;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable exception) {
		ErrorMessage errorMassage=new ErrorMessage(exception.getMessage(), 404, "www.google.com");
		
		return Response.status(Status.NOT_FOUND).entity(errorMassage).build();
	}

}
