package org.dnyanyog.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouterConfig {
  @Bean
  public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
    return builder
        .routes()
        // directory service
        .route(
            "directory_login_route",
            r -> r.path("/api/v1/directory/validate/**").uri("http://localhost:8081"))
        .route(
            "directory_add_route",
            r -> r.path("/api/v1/directory/add/**").uri("http://localhost:8081"))
        .route(
            "directory_get_route",
            r -> r.path("/api/v1/directory/{user_id}").uri("http://localhost:8081"))
        .route(
            "directory_delete_route",
            r -> r.path("/api/v1/directory/{user_id}").uri("http://localhost:8081"))
        .route(
            "directory_update_route",
            r -> r.path("/api/v1/directory/{user_id}").uri("http://localhost:8081"))
        // patient service
        .route(
            "patient_add_route", r -> r.path("/api/v1/patient/add/**").uri("http://localhost:8082"))
        .route(
            "patient_get_route",
            r -> r.path("/api/v1/patient/{patient_id}").uri("http://localhost:8082"))
        .route(
            "patient_delete_route",
            r -> r.path("/api/v1/patient/{patient_id}").uri("http://localhost:8082"))
        .route(
            "patient_update_route",
            r -> r.path("/api/v1/patient/{patient_id}").uri("http://localhost:8082"))
        // appointment service
        .route(
            "appointment_add_route",
            r -> r.path("/api/v1/appointment/add/**").uri("http://localhost:8085"))
        .route(
            "appointment_get_route",
            r -> r.path("/api/v1/appointment/patient/{patient_id}").uri("http://localhost:8085"))
        .route(
            "appointment_get_route",
            r -> r.path("/api/v1/appointment/{appointment_id}").uri("http://localhost:8085"))
        .route(
            "appointment_delete_route",
            r -> r.path("/api/v1/appointment/{appointment_id}").uri("http://localhost:8085"))
        .route(
            "appointment_update_route",
            r -> r.path("/api/v1/appointment/{appointment_id}").uri("http://localhost:8085"))
        // case service
        .route("case_add_route", r -> r.path("/api/v1/case/add/**").uri("http://localhost:8084"))
        .route(
            "casse_get_route",
            r -> r.path("/api/v1/case/{patient_id}").uri("http://localhost:8084"))
        .route(
            "case_get_route",
            r -> r.path("/api/v1/case/patient/{case_id}").uri("http://localhost:8084"))
        .route(
            "case_delete_route", r -> r.path("/api/v1/case/{case_id}").uri("http://localhost:8084"))
        .route(
            "case_update_route", r -> r.path("/api/v1/case/{case_id}").uri("http://localhost:8084"))
        .build();
  }
}
