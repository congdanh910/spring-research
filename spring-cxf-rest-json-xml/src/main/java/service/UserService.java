package service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.User;
import vo.UserCollection;

@Path("/user-service/")
@Produces("application/xml")
public interface UserService {
	
	    @GET
	    @Path("/users")
	    @Produces({"application/xml", "application/json"})
	    public UserCollection getUsers();

	    @GET
	    @Path("/user/{id}")
	    public User getUser(@PathParam("id") Integer id);

	    @GET
	    @Path("/users/bad")
	    public Response getBadRequest();
	    
	    @POST
	    @Path("/new")
		@Produces(MediaType.TEXT_HTML)
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public void newUser(
				@FormParam("id") Integer id,
				@FormParam("name") String name,
				@Context HttpServletResponse servletResponse
		) throws IOException;
	    

	}