package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@GetMapping("/hrServiceFallback")
	public String hrServiceDown() {
		return "Hr Service currently down";
	}

	@Bean
	public RouteLocator routes(RouteLocatorBuilder rb) {

		return rb.routes()
				.route(r -> r.path("/emp/**").uri("lb://emp-data-service"))
				.route(r -> r.path("/hr/**")
						.filters(f -> f.circuitBreaker(
								config -> config.setFallbackUri("/hrServiceFallback").setName("hr-service-config")))
						.uri("lb://hr-service"))
				.route(r -> r.path("/redirect-test/**").uri("http://www.google.co.in")).build();
	}
}
