package org.springframework.samples.petclinic.api.cfg;


import org.springframework.beans.factory.annotation.Value;

/**
 * @author skerdudou Remove basePath from outgoing request
 */
//@Component
public class StripBasePathGatewayFilterFactory
//		extends AbstractGatewayFilterFactory<StripBasePathGatewayFilterFactory.Config> 
{

	@Value("${spring.webflux.base-path}")
	private String basePath;
	/**
	 * Parts key.
	 */
	public static final String PARTS_KEY = "parts";

//	public StripBasePathGatewayFilterFactory() {
//		super(StripBasePathGatewayFilterFactory.Config.class);
//	}
//
//	@Override
//	public List<String> shortcutFieldOrder() {
//		return Arrays.asList(PARTS_KEY);
//	}
//
//	@Override
//	public GatewayFilter apply(Config config) {
//		return (exchange, chain) -> {
//			ServerHttpRequest req = exchange.getRequest();
//			String path = req.getURI().getRawPath();
//			String newPath = path.replaceFirst(basePath, "");
//
//			ServerHttpRequest request = req.mutate().path(newPath).contextPath(null).build();
//
//			return chain.filter(exchange.mutate().request(request).build());

//			ServerHttpRequest request = exchange.getRequest();
//			ServerWebExchangeUtils.addOriginalRequestUrl(exchange, request.getURI());
//			String path = request.getURI().getRawPath();
//			String[] originalParts = StringUtils.tokenizeToStringArray(path, "/");
//
//			// all new paths start with /
//			StringBuilder newPath = new StringBuilder("/");
//			for (int i = 0; i < originalParts.length; i++) {
//				if (i >= config.getParts()) {
//					// only append slash if this is the second part or greater
//					if (newPath.length() > 1) {
//						newPath.append('/');
//					}
//					newPath.append(originalParts[i]);
//				}
//			}
//			if (newPath.length() > 1 && path.endsWith("/")) {
//				newPath.append('/');
//			}
//
//			ServerHttpRequest newRequest = request.mutate().path(newPath.toString()).contextPath(null).build();
//
//			exchange.getAttributes().put(ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR, newRequest.getURI());
//
//			return chain.filter(exchange.mutate().request(newRequest).build());
//		};
//	}
//
//	public static class Config {
//
//		private int parts;
//
//		public int getParts() {
//			return parts;
//		}
//
//		public void setParts(int parts) {
//			this.parts = parts;
//		}
//
//	}
}
