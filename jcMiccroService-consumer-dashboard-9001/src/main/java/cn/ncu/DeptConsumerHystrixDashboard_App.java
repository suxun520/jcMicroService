package cn.ncu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
//服务监控步骤  1，加坐标(hystrix  hystrix-dashboard)  2.加注解@EnableHystrixDashboard  3.要监控的服务上要加actuaor依赖
public class DeptConsumerHystrixDashboard_App
{
	public static void main(String[] args)
	{
		SpringApplication.run(DeptConsumerHystrixDashboard_App.class, args);
	}
}
