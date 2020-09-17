package com.zj.C85S3Blog.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {
	
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory faction){
		RedisTemplate<String, Object> template=new RedisTemplate<String, Object>();
		template.setConnectionFactory(faction);
		
		
		
		
		
		return template;
		
	} 

}
