package service;

import javax.ws.rs.core.Response;

import junit.framework.TestCase;

import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.log4j.Logger;
import org.junit.Test;

public class TestService extends TestCase{

    // @Resource(type = UserServiceImpl.class)
    // private ServiceDefn service;
	Logger logger = Logger.getLogger(TestService.class);

    @Test
    public void testGetUsers() {
    	/*WebClient wc = WebClient.create("http://localhost:8080/cxf-rest/rs/user-service");
    	//wc.accept("application/json");
    	Response res = wc.path("/users").get();
    	System.out.println(res.getEntity().toString());*/
    	
    	System.out.println(invokeService("http://localhost:8080/cxf-rest/rs/user-service/users"));
    }

    private String invokeService(String targetURL) {
        WebClient webClient = WebClient.create(targetURL);
        //webClient.accept("application/json");
        return webClient.get(String.class);
    }
}
