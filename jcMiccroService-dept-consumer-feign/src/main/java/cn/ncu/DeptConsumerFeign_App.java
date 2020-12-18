package cn.ncu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import cn.LBRule.MyLBRule;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("cn.ncu")              // feign基于ribbon实现   使用ribbon还要ribbon+restTmplate  面向微服务名字   不符合编程习惯     
//  feign实现服务绑定接口   即只需要在Feign根据微服务名字注册微服务  实现了面向接口编程
// 步骤     1.feign客户端引包(config eureka ribbon  feign)    2.加注解 @EnableFeignClients   3.在api工程中  通过@feignClient注解将微服务跟接口绑定
@RibbonClient(name = "MICROSERVICECLOUD-DEPT",configuration =  MyLBRule.class)
// feign集成自定义负载均衡算法  feign默认轮询    有2种方式实现自定义负载均衡   1.配置文件 微服务名.ribbon.NFLoadBalancerRuleClassName=负载均衡算法类全路径
//  2.  配置方式   Irule   返回自定义负载均衡算法类     配置大于编码
public class DeptConsumerFeign_App
{
	public static void main(String[] args)
	{
		SpringApplication.run(DeptConsumerFeign_App.class, args);
	}
}
