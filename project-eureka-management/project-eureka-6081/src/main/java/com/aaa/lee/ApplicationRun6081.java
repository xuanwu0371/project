package com.aaa.lee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * create by: lee
 * description:
 */
@SpringBootApplication
@EnableEurekaServer
public class ApplicationRun6081 {
    public static void main(String[] args) {
      SpringApplication.run(ApplicationRun6081.class,args);
    }
}
