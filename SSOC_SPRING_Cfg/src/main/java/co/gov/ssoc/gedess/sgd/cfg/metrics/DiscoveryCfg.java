package co.gov.ssoc.gedess.sgd.cfg.metrics;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Profile;

@Profile("!prod")
//@EnableDiscoveryClient
public class DiscoveryCfg {

}
