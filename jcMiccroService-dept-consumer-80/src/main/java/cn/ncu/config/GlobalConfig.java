package cn.ncu.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class GlobalConfig {
    
	@Bean
	@LoadBalanced  //开负载均衡
	public  RestTemplate   getRestTemplate() {
		return  new  RestTemplate();
	}
	
	@Bean    //ribbon自带7中负载均衡算法  
	public   IRule   myRule() {
		return  new  RandomRule();
	}
	
	
}
