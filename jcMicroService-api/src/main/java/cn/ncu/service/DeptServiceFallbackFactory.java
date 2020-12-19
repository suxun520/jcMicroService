package cn.ncu.service;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.ncu.entity.Dept;
import feign.hystrix.FallbackFactory;

//服务降级 跟客户端有关系  跟服务端没关系
@Component
public class DeptServiceFallbackFactory implements FallbackFactory<DeptFeignService> {

	@Override
	public DeptFeignService create(Throwable cause) {
		
		return new   DeptFeignService() {
			
			@Override
			public List<Dept> list() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Dept get(Long id) {
				return new  Dept().setDeptno(id).setDname("该服务已关闭  已进行降级处理  ----").setDb_source("no  availablle  datasource");
			}
			
			@Override
			public Object disCovery() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean add(Dept dept) {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}

}
