package cn.ncu.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.ncu.entity.Dept;
import cn.ncu.service.DeptService;

@RestController
public class DeptController {
	@Autowired
	private DeptService service;

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Dept dept) {
		return service.add(dept);
	}

	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id) {
		return service.get(id);
	}

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list() {
		return service.list();
	}

	@Autowired
	private DiscoveryClient client;

	// 写一个接口 返回微服务信息
	@RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
	public Object disCovery() {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		List<String> services = client.getServices(); // 这个就是微服务spring.application.name值
		hashMap.put("serviceList", services);
     
		System.out.println(services);
		
		List<ServiceInstance> instances = client.getInstances(services.get(0));
		for (ServiceInstance serviceInstance : instances) {
			hashMap.put("ServiceId", serviceInstance.getServiceId());
			hashMap.put("host", serviceInstance.getHost());
			hashMap.put("port", serviceInstance.getPort());
			hashMap.put("uri", serviceInstance.getUri());
		}
		return hashMap;
	}

}
