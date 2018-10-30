package com.bhl.ehotel.datasync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class EhotelDataSyncServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EhotelDataSyncServiceApplication.class, args); 
	}
	
	@Bean
	public JedisPool jedisPool() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(100);
		config.setMaxIdle(5);
		config.setMaxWaitMillis(1000 * 10); 
		config.setTestOnBorrow(true);
		return new JedisPool(config, "10.0.0.3", 1111);
	}
	
}
