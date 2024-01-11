package com.bolsadeideas.springboot.webflux.app;

import com.bolsadeideas.springboot.webflux.app.handler.ProductoHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;

@Configuration
public class RouterFunctionConfig {
    @Bean
    public RouterFunction<ServerResponse> routes(ProductoHandler handler) {
        return RouterFunctions.route(RequestPredicates.GET("/api/v2/productos").or(RequestPredicates.GET("/api/v3/productos")), handler::listar)
                .andRoute(RequestPredicates.GET("/api/v2/productos/{id}"), handler::ver)
                .andRoute(RequestPredicates.POST("/api/v2/productos"), handler::crear)
                .andRoute(RequestPredicates.PUT("/api/v2/productos/{id}"), handler::editar)
                .andRoute(RequestPredicates.DELETE("/api/v2/productos/{id}"), handler::eliminar)
                .andRoute(RequestPredicates.POST("/api/v2/productos/upload/{id}"), handler::upload)
                .andRoute(RequestPredicates.POST("/api/v2/productos/crear"), handler::crearConFoto);
    }
}
