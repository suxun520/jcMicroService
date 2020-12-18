package cn.LBRule;

import java.util.List;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

/**   
* <p>Title: Round5RobinRule.java</p>   
* <p>Description:自定义的负载均衡算法  基于   轮询  每台机器轮询5次 </p>   
* @author 经成  
* @date 2020年12月16日 下午10:32:03  
*/  
public class Round5RobinRule extends AbstractLoadBalancerRule {

	
	private   int  total=0;    //统计调用次数  达到5次换服务
	private  int  currentIndex=0;   //当前服务号
   
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }

          
            //start   核心业务代码
            if  (total>=5) {
            	total=0;//计数器归零
            	currentIndex++;
            	if (currentIndex>=upList.size()) {
            		currentIndex=0;
            	}
            }
            server=upList.get(currentIndex);
            total++;
            //end  核心业务代码
            
            

            
            
            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

   

	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(), key);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {
		// TODO Auto-generated method stub
		
	}
}