package org.example;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author johoka
 */
@SpringBootApplication
@SpringBootConfiguration
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

//    @ConfigurationProperties(prefix = "spring.datasource")
//    @Bean
//    public DruidDataSource druidDataSource(){
//        return new DruidDataSource();
//    }

    @Bean
    public TestService testService(){
        return new TestServiceImpl();
    }

}
