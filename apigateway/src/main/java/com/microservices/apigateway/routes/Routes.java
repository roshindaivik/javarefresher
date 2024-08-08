package com.microservices.apigateway.routes;

import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.*;
import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;


@Configuration
public class Routes {


    private static final String CAMPAIGN_SERVICE_URL = "http://localhost:8081";
    private static final String PUBLISHER_SERVICE_URL = "http://localhost:8000";

    @Bean
    public RouterFunction<ServerResponse> campaignServiceRoutes() {
        return GatewayRouterFunctions.route("campaign_service")
                .route(RequestPredicates.path("/api/campaign/**"), HandlerFunctions.http(CAMPAIGN_SERVICE_URL))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> publisherServiceRoutes() {
        return GatewayRouterFunctions.route("publisher_service")
                .route(RequestPredicates.path("/api/publishers/**"), HandlerFunctions.http(PUBLISHER_SERVICE_URL))
                .build();
    }

}
