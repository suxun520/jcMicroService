package cn.ncu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
//使用eureka-server(注册中心)     1.引jar包  2.主配置文件  3.启动入口加@@EnableEurekaServer
//使用eureka实现服务注册(服务注册全部操作在具体要对外提供的微服务中完成)    1.引入jar包  2.主配置文件   3.加入注解enableEurekaClient
public class Rureka7002App {
   
	
	public static void main(String[] args) {
		SpringApplication.run(Rureka7002App.class, args);
	}
}
