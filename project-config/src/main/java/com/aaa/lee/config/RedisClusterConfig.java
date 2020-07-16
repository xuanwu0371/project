package com.aaa.lee.config;

import com.aaa.lee.properties.RedisClusterProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * create by: lee
 * description:
 */
@Configuration
public class RedisClusterConfig {

    @Autowired
    private RedisClusterProperties redisClusterProperties;

    @Bean
    public JedisCluster getJedisCluster() {
        String nodes = redisClusterProperties.getNodes();
        String[] split = nodes.split(",");
        Set<HostAndPort> hostAndPortSet = new HashSet<HostAndPort>();
        for (String hostPort : split) {
            String[] split1 = hostPort.split(":");//0:ip , 1: prot
            HostAndPort hostAndPort = new HostAndPort(split1[0], Integer.parseInt(split1[1]));
            hostAndPortSet.add(hostAndPort);
        }
        return new JedisCluster(hostAndPortSet, redisClusterProperties.getCommandTimeout(), redisClusterProperties.getMaxAttempts());
    }
}
