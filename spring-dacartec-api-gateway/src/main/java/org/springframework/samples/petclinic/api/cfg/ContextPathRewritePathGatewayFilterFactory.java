package org.springframework.samples.petclinic.api.cfg;

/**
 * @author bnasslahsen
 */
//@Component
public class ContextPathRewritePathGatewayFilterFactory
//extends RewritePathGatewayFilterFactory 
{

//	@Override
//	public GatewayFilter apply(Config config) {
//		String replacement = config.getReplacement().replace("$\\", "$");
//		return (exchange, chain) -> {
//			ServerHttpRequest req = exchange.getRequest();
//
//			addOriginalRequestUrl(exchange, req.getURI());
//			String path = req.getURI().getRawPath();
//
//			String newPath = path.replaceAll(config.getRegexp(), replacement);
//			ServerHttpRequest request = req.mutate().path(newPath).contextPath("/")
////					.contextPath(null)
//					.build();
//
//			exchange.getAttributes().put(GATEWAY_REQUEST_URL_ATTR, request.getURI());
////			exchange.getAttributes().put(GATEWAY_REQUEST_URL_ATTR, "/vets-service/v3/api-docs");
////			exchange.getAttributes().put(GATEWAY_REQUEST_URL_ATTR, "http://localhost:8082/vets-service/v3/api-docs");
//
//			return chain.filter(exchange.mutate().request(request).build());
//		};
//	}

}