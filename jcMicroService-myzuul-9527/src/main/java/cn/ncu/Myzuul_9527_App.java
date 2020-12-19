package cn.ncu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy   
//zuul使用步骤  1 加依赖(eureka 因为zuul也要注册进eureka中  zuul)  2.配置文件  3.加注解@EnableZuulProxy
public class Myzuul_9527_App
{
	public static void main(String[] args)
	{
		SpringApplication.run(Myzuul_9527_App.class, args);
	}
}
