package cn.ncu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import cn.LBRule.MyLBRule;

@SpringBootApplication
@EnableEurekaClient    //（ribbon是一款基于客户端负载均衡工具，必须与eureka整合使用）使用ribbon步骤  1.加三个依赖(eureka ribbonn config)  2.配置文件  加入
                         //eureka服务器地址   3.在客户端连接工具中(本案例是restTemplate@bean上加@loadBalanced)   4.访问地址改成微服务名字 (客户端工具根据微服务名字调用微服务)
@RibbonClient(name = "MICROSERVICECLOUD-DEPT",configuration =  MyLBRule.class)  //配置该微服务的负载均衡算法  注意负载均衡算法类不能放在主启动类所在包及子包下
public class DeptConsumer80_App
{
	public static void main(String[] args)
	{
		SpringApplication.run(DeptConsumer80_App.class, args);
	}
}
