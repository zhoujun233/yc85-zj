package kuang;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;

public class Redis {
	
	@Resource
	private RedisTemplate redisTemplate;
	
	public static void main(String[] args) {
		
	}

}
