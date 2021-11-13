package huseyin.ocal.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
@EnableEurekaClient
public class GatewayServerApplication {
    
    private static final String X_RESPONSE_TIME = "X-Response-Time";

    public static void main(String[] args) {
        SpringApplication.run(GatewayServerApplication.class, args);
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
            .route(predicateSpec -> predicateSpec
                .path("/huseyinocal/account/**")
                .filters(f -> f.rewritePath("/huseyinocal/account/(?<segment>.*)","/${segment}")
                    .addResponseHeader(X_RESPONSE_TIME,new Date().toString()))
                .uri("lb://ACCOUNT")).

                route(predicateSpec -> predicateSpec
                    .path("/huseyinocal/loan/**")
                    .filters(f -> f.rewritePath("/huseyinocal/loan/(?<segment>.*)","/${segment}")
                        .addResponseHeader(X_RESPONSE_TIME,new Date().toString()))
                    .uri("lb://LOAN")).

                route(predicateSpec -> predicateSpec
                    .path("/huseyinocal/card/**")
                    .filters(f -> f.rewritePath("/huseyinocal/card/(?<segment>.*)","/${segment}")
                        .addResponseHeader(X_RESPONSE_TIME,new Date().toString()))
                    .uri("lb://CARD")).build();
    }

}
