/*
 * Copyright 2002-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.api.boundary.web;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.api.dto.OwnerDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;

import lombok.RequiredArgsConstructor;

/**
 * @author Maciej Szarlinski
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/gateway")
public class ApiGatewayController {

	@GetMapping(value = "owners/{ownerId}")
	public ResponseEntity<OwnerDetails> getOwnerDetails(final @PathVariable int ownerId) {
		return new ResponseEntity<OwnerDetails>(new OwnerDetails(), HttpStatus.ACCEPTED);

	}

	private final String servicePattern = "\\-(?<name>.*?)\\-service";

	@Autowired
	private EurekaClient discoveryClient;

	@GetMapping("/swagger-config.json")
	public Map<String, Object> swaggerConfig() {
		Map<String, Object> rtn = new LinkedHashMap<>();
		List<Map<String, String>> urls = new LinkedList<>();

		discoveryClient.getApplications().getRegisteredApplications().forEach(application -> {
			Pattern p = Pattern.compile(servicePattern, Pattern.CASE_INSENSITIVE);
			Matcher m = p.matcher(application.getName());

//			if (m.find()) {
//				String g = m.group(1);
//				String serviceName = application.getName();
			String serviceName = application.getInstances().get(0).getInstanceId().split(":")[1];

			Map<String, String> url = new LinkedHashMap<>();
			url.put("url", "/" + serviceName + "/v2/api-docs");
			url.put("name", serviceName);
			urls.add(url);
//			}
		});

		rtn.put("urls", urls);
		return rtn;
	}
}
