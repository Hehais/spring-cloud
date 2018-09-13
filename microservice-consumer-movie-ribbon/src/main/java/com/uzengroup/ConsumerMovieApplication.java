package com.uzengroup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.hehai.config.RibbonConfiguration;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "microservice-provider-user",configuration = RibbonConfiguration.class)
public class ConsumerMovieApplication {

	@Bean
	@LoadBalanced  //标明rest开启负载均衡
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(ConsumerMovieApplication.class, args);
	}
}
