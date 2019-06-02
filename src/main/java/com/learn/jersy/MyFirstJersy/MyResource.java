package com.learn.jersy.MyFirstJersy;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import com.learn.jersy.DaoImpl.MessageDaoImpl;
import com.learn.jersy.Exception.DataNotFoundException;
import com.learn.jersy.beans.Message;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/myresource/")
public class MyResource {

	MessageDaoImpl messageDaoImpl =new MessageDaoImpl(); 
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
     public String hello() 
    	{
            return "Hellofiroz1	";
        }
    @GET
    @Path("/your")
    @Produces(MediaType.TEXT_PLAIN)
     public String quary(@QueryParam("name") String name) 
    	{
    	
    	System.out.println(name);

    	return "Hello "+name;
        }  
    
@GET
@Path("/message")
//@Produces("application/json")
@Produces(MediaType.APPLICATION_JSON)
public List<Message> getMessage() 
	{
	System.out.println(messageDaoImpl.getMessage());
	 return messageDaoImpl.getMessage();
	 
    }  
@GET
@Path("/getXmlData")
@Produces(MediaType.APPLICATION_XML)
public List<Message> getXmlData() { // from path
	List<Message> data= messageDaoImpl.getMessage();
	return data;
}
@GET
@Path("/getjsonData")
@Produces(MediaType.APPLICATION_JSON)
public Response getMsg() { 
	List<Message> data= messageDaoImpl.getAllMessage();
	System.out.println(Response.status(200).entity(data).build());
	return Response.status(200).entity(data).build();
}

@GET
//@Path("/{id}")
@Produces(MediaType.APPLICATION_JSON)
public Response getParamdata(@PathParam ("id")String id) { 
	List<Message> data= messageDaoImpl.getMessage();
	System.out.println(Response.status(200).entity(data).build());
	return Response.status(200).entity(data).build();
}

@POST
@Path("/id={id}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Response post(@PathParam("id")int id ,@Context UriInfo info) throws URISyntaxException 
{ 
   	URI url = info.getAbsolutePathBuilder().path(String.valueOf(id)).build();

   	System.out.println(info.getPath());
if (id<0|id==0)
{
	return Response.created(url).entity("Id Can't should be Greater then Zero").build();
}
else if(id>0) {
	List<Message> data= messageDaoImpl.getMessage();
	System.out.println(" id "+id);
		
	System.out.println(Response.status(200).entity(data).build());
	return Response.created(url).entity(data).build();
}
return Response.created(url).entity("ID Can't be Null").build();
}


//----------------------Exception ---------

@POST
@Path("/Exception={id}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Response exceptionhand(@PathParam("id")int id ,@Context UriInfo info) throws DataNotFoundException 
{ 
System.out.println(" inside Service ");
	URI url = info.getAbsolutePathBuilder().path(String.valueOf(id)).build();

   	System.out.println(info.getPath());
if (id<0|id==0)
{
        throw new DataNotFoundException(" does not existing on this server !!");
    
	//return Response.created(url).entity("Id Can't should be Greater then Zero").build();
}
else if(id>0) {
	List<Message> data= messageDaoImpl.getMessage1(1);
	System.out.println(" id "+id);
		
	System.out.println(Response.status(200).entity(data).build());
	return Response.created(url).entity(data).build();
}
return Response.created(url).entity("ID Can't be Null").build();
}


}
