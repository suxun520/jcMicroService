package cn.ncu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient   //服务发现
@EnableCircuitBreaker   //hystrix是针对服务发生异常时 防止服务发生雪崩  让微服务链能正常运行的功能库 
//  服务熔断  当某个微服务响应时间太久或者不开用时  快速熔断该服务的调用 快速返回错误的响应信息    使用步骤：1.加坐标   2.修改controller  加注解@hystrixCommand表示发生错误的回调方法   3.主启动类加@EnableCircuitBreaker
public class DeptHystrixProvider8001_App
{
	public static void main(String[] args)
	{
		SpringApplication.run(DeptHystrixProvider8001_App.class, args);
	}
}
