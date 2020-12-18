package cn.ncu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ncu.entity.Dept;
import cn.ncu.service.DeptFeignService;

/**   
* <p>Title: DeptConsumerFeignController.java</p>   
* <p>Description:  feign客户端 </p>   
* @author 经成  
* @date 2020年12月18日 下午4:17:32  
*/  
@RestController
public class DeptConsumerFeignController {

	@Autowired
	private DeptFeignService deptFeignService;

	@RequestMapping(value = "/consumer/dept/add")
	public boolean add(Dept dept) {
		return deptFeignService.add(dept);
	}

	@RequestMapping(value = "/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return deptFeignService.get(id);
	}

	@RequestMapping(value = "/consumer/dept/list")
	public List<Dept> list() {
		return deptFeignService.list();
	}

	@RequestMapping(value = "/consumer/dept/discovery")
	public Object discovery() {
		return deptFeignService.disCovery();
	}

}
