package cn.ncu.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.ncu.entity.Dept;

/**   
* <p>Title: DeptFeignService.java</p>   
* <p>Description:服务绑定接口    客户端直接调用这个接口就可以</p>   
* @author 经成  
* @date 2020年12月18日 下午4:12:02  
*/  
@FeignClient("MICROSERVICECLOUD-DEPT")
public interface DeptFeignService {
   
	
	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Dept dept) ;

	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id) ;

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list() ;


	// 写一个接口 返回微服务信息
	@RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
	public Object disCovery() ;
		
}
