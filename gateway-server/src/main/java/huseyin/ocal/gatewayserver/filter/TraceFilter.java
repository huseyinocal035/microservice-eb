//package huseyin.ocal.gatewayserver.filter;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpHeaders;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//@Slf4j
//@Order(1)
//@Component
//@RequiredArgsConstructor
//public class TraceFilter implements GlobalFilter {
//
//    private final FilterUtility filterUtility;
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        HttpHeaders requestHeaders = exchange.getRequest().getHeaders();
//        if (isCorrelationIdPresent(requestHeaders)) {
//            log.debug("EazyBank-correlation-id found in tracing filter: {}. ",
//                filterUtility.getCorrelationId(requestHeaders));
//        } else {
//            String correlationID = generateCorrelationId();
//            exchange = filterUtility.setCorrelationId(exchange, correlationID);
//            log.debug("EazyBank-correlation-id generated in tracing filter: {}.", correlationID);
//        }
//        return chain.filter(exchange);
//    }
//
//    private boolean isCorrelationIdPresent(HttpHeaders requestHeaders) {
//        return filterUtility.getCorrelationId(requestHeaders) != null;
//    }
//
//    private String generateCorrelationId() {
//        return java.util.UUID.randomUUID().toString();
//    }
//
//}
