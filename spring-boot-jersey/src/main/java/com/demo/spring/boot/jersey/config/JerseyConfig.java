package com.demo.spring.boot.jersey.config;

import com.demo.spring.boot.jersey.controller.HealthController;
import com.demo.spring.boot.jersey.controller.StaffController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

/**
 * Created by CongDanh on 10/11/15.
 *
 * Depending on the spring.jersey.type property value either Jersey Servlet or Filter is registered as a Spring Bean:
 * Mapping servlet: 'jerseyServlet' to [/*]
 * The default mapping path can be changed via javax.ws.rs.ApplicationPath annotation added to ResourceConfig configuration class:
 *
 * @ApplicationPath("/jersey")
 */

@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(HealthController.class);
        register(StaffController.class);
    }
}
