package cn.LBRule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;




/**   
* <p>Title: MyLBRule.java</p>   
* <p>Description:负载均衡算法配置类 </p>   
* @author 经成  
* @date 2020年12月16日 下午6:49:52  
*/  
@Configuration
public class MyLBRule {

	@Bean
	public  IRule  myRule() {
		return  new  Round5RobinRule();
	}
	
}
