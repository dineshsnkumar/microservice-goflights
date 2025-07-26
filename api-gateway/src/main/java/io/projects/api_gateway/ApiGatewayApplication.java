package io.projects.api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;

import java.time.Duration;

@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator config(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(p -> p.path("/goflights/customers/**")
                        .filters(f -> f.rewritePath("/goflights/customers/(?<segment>.*)", "/${segment}")
                                .circuitBreaker(config -> config.setName("customersCircuitBreaker").setFallbackUri("forward:/contact"))
                                .retry(retryConfig -> retryConfig.setRetries(5).setMethods(HttpMethod.GET).
                                        setBackoff(Duration.ofMillis(100), Duration.ofMillis(1000), 2, true)))
                        .uri("lb:CUSTOMERS")).build();
    }
}
