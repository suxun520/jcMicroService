package cn.ncu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import cn.ncu.entity.Dept;
import cn.ncu.service.DeptService;

@RestController
public class DeptController {
	@Autowired
	private DeptService service;

	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "getDeptByIdFallback")    // 回调函数 返回参数必须跟这个一致
	public Dept get(@PathVariable("id") Long id) {
		Dept dept = service.get(id);
		if (dept == null) {
			throw new RuntimeException("该dept id不存在");
		} else {
			return dept;
		}
	}
  //这样写有个问题  一个方法对应一个异常方法  会造成方法冗余 不符合aop思想  所以需要改进
	//改进方法  在api 接口层  注解加个参数  fallbackFactiry  参数是类  该类实现fallbackFactory   要在feign工程开启hystrix
	public Dept getDeptByIdFallback(@PathVariable("id") Long id) {
		return new  Dept().setDeptno(id).setDname("exception process").setDb_source("no  available   datasource");
	}

}
