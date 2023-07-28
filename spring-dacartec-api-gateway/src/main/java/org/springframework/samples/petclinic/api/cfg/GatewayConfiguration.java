package org.springframework.samples.petclinic.api.cfg;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("!prod")
@EnableDiscoveryClient
//@EnableDiscoveryClient
public class GatewayConfiguration {

//	@Bean
//	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
//		return builder.routes()
//				.route("service-route",
//						r -> r.path("/api/**").filters(f -> f.stripPrefix(1)).uri("lb://service-registry-name"))
//				.build();
//	}
//	@Bean
//	@Lazy(false)
//	public List<GroupedOpenApi> apis(RouteDefinitionLocator locator) {
//		List<GroupedOpenApi> groups = new ArrayList<>();
//		List<RouteDefinition> definitions = locator.getRouteDefinitions().collectList().block();
//		for (RouteDefinition definition : definitions) {
//			System.out.println("id: " + definition.getId() + "  " + definition.getUri().toString());
//		}
//		definitions.stream().filter(routeDefinition -> routeDefinition.getId().matches(".*-service"))
//				.forEach(routeDefinition -> {
//					String name = routeDefinition.getId().replaceAll("-service", "");
//					groups.add(GroupedOpenApi.builder().pathsToMatch("/" + name + "/**").group(name).build());
//				});
//		return groups;
//	}
}
