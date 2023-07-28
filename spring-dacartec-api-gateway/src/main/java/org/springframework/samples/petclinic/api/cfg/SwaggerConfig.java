package org.springframework.samples.petclinic.api.cfg;

import java.util.ArrayList;
import java.util.List;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig
//implements WebFluxConfigurer 
{

	@Bean
	public OpenAPI springShopOpenAPI() {
		// Retrieve available services from the discovery client
		OpenAPI openAPI = new OpenAPI()
				.info(new Info().title("API Gateway").description("Spring api gateway application").version("v0.0.1")
						.license(new License().name("Apache 2.0").url("http://springdoc.org")))
				.externalDocs(new ExternalDocumentation().description("GEDES docs")
						.url("https://springshop.wiki.github.org/docs"));

		List<String> instances = discoveryClient.getServices();

		// Build the Swagger UI URLs for each service instance
		for (String instance : instances) {
			String swaggerUrl = "http://localhost:8082/" + instance + "";
//			openAPI.addServersItem(new Server().url(swaggerUrl).description(instance));
		}
		return openAPI;
	}

//	@Autowired
//	RouteDefinitionLocator locator;
//
//	@Bean
//	public List<GroupedOpenApi> apis() {
//		List<GroupedOpenApi> groups = new ArrayList<>();
//		List<RouteDefinition> definitions = locator.getRouteDefinitions().collectList().block();
//		definitions.stream().filter(routeDefinition -> routeDefinition.getId().matches(".*-SERVICE"))
//				.forEach(routeDefinition -> {
//					String name = routeDefinition.getId().replaceAll("-SERVICE", "");
//					groups.add(GroupedOpenApi.builder().group(name).pathsToMatch("/" + name + "/**").build());
//				});
//		return groups;
//	}

//	@Bean
//	public GroupedOpenApi api() {
//		return GroupedOpenApi.builder().group("API Gateway").pathsToMatch("/**").build();
//	}
//	@Bean
//	public GroupedOpenApi publicApi() {
//		return GroupedOpenApi.builder().group("springshop-public").pathsToMatch("/public/**").build();
//	}
//
//	@Bean
//	public GroupedOpenApi adminApi() {
//		return GroupedOpenApi.builder().group("springshop-admin").pathsToMatch("/admin/**")
//				.addOpenApiMethodFilter(method -> method.isAnnotationPresent(Admin.class)).build();
//	}

//	@Bean
//	public GroupedOpenApi customOpenApi() {
//		String[] paths = { "/service/**" }; // Replace with the desired paths for Swagger documentation
//		return GroupedOpenApi.builder().group("Service API").pathsToMatch(paths).build();
//	}
//	@Autowired
//	private RouteDefinitionLocator locator;

//	@Bean
//	public List<GroupedOpenApi> apis() {
//		List<GroupedOpenApi> groups = new ArrayList<>();
//		List<RouteDefinition> definitions = locator.getRouteDefinitions().collectList().block();
//		definitions.stream().filter(routeDefinition -> routeDefinition.getId().matches(".*_route"))
//				.forEach(routeDefinition -> {
//					String name = routeDefinition.getId().replaceAll("_route", "");
//					GroupedOpenApi api = GroupedOpenApi.builder().pathsToMatch("/" + name + "/**").group(name).build();
//					groups.add(api);
//				});
//		return groups;
//	}
//	@Bean
//	public List<GroupedOpenApi> apis() {
//		List<GroupedOpenApi> groups = new ArrayList<>();
//		discoveryClient.getServices().stream().forEach(routeDefinition -> {
//			GroupedOpenApi api = GroupedOpenApi.builder().pathsToMatch("/" + routeDefinition + "/**")
//					.group(routeDefinition).build();
//			groups.add(api);
//		});
//		return groups;
//	}

	@Autowired
	private DiscoveryClient discoveryClient;

//	@Bean
//	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//		RouteLocatorBuilder.Builder routes = builder.routes();
//
////		discoveryClient.getServices().forEach(serviceId -> {
////			routes.route(serviceId,
////					r -> r.path("/" + serviceId + "/**")
////					.uri("http://localhost:8083/" + serviceId)
//////					.uri("lb://" + serviceId)
////					
////					);
////		});
//
//		routes.route("vets-service", r -> r.path("/vets-service/**")
////				.uri("http://localhost:8082/" + serviceId)
//				.uri("http://localhost:8082/vets-service/")
////				.uri("lb://" + serviceId)
//
//		);
//		return routes.build();
//	}
//
//	@Bean
//	public GroupedOpenApi groupedOpenApi() {
//		return GroupedOpenApi.builder().group("services").pathsToMatch("/services/**").build();
//	}

}

//class SwaggerResourceResolver implements ResourceResolver {
//
//	private final String swaggerUrl;
//
//	public SwaggerResourceResolver(String swaggerUrl) {
//		this.swaggerUrl = swaggerUrl;
//	}
//
//	@Override
//	public Mono<String> resolveUrlPath(String resourcePath, List<? extends Resource> locations,
//			ResourceResolverChain chain) {
//		if ("/swagger-ui/index.html".equals(resourcePath)) {
//			ServerWebExchange exchange = ServerWebExchange.current();
//			String baseUrl = exchange.getRequest().getPath().contextPath().value();
//			String urlPath = baseUrl + "swagger-ui/index.html?url=" + swaggerUrl;
//			return Mono.just(urlPath);
//		}
//		return chain.resolveUrlPath(resourcePath, locations);
//	}
//}