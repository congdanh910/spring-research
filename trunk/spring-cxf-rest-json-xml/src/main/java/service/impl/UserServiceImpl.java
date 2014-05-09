package service.impl;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.lang.builder.ToStringBuilder;

import model.User;
import service.UserService;
import vo.UserCollection;


public class UserServiceImpl implements UserService {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

    private static Map<Integer, User> users = new HashMap<Integer, User>();

    static {
        users.put(1, new User(1, "Sushant"));
        users.put(2, new User(2, "Abhinav"));
    }

    public UserServiceImpl() {}

    @Override
    public UserCollection getUsers() {    	
        return new UserCollection(users.values());
    }

    @Override
    public User getUser(Integer id) {
        return users.get(id);
    }

    @Override
    public Response getBadRequest() {
        return Response.status(Status.BAD_REQUEST).build();
    }
    
    @Override
	public void newUser(Integer id,String name,	HttpServletResponse servletResponse) throws IOException {
			User user = new User(id,name);
			users.put(id, user);
		URI uri = uriInfo.getAbsolutePathBuilder().path(id.toString()).build();
		Response.created(uri).build();
		
		servletResponse.sendRedirect("../../postUser.jsp");
	}

    

}
