package org.example;

import org.example.aspect.Agent;
import org.example.circularreferences.AServiceImpl;
import org.example.circularreferences.BServiceImpl;
import org.example.placeholder.PlaceholderBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableAspectJAutoProxy
@PropertySource("classpath:test.properties")
public class App 
{
    public static void main( String[] args ) throws InterruptedException {
//        ConfigurableApplicationContext run = SpringApplication.run(App.class, args);
//        Agent agent = run.getBean(Agent.class);
//        PlaceholderBean placeholderBean = run.getBean(PlaceholderBean.class);
//        System.out.println(placeholderBean);
//        System.out.println(placeholderBean.getValue());
//        ConfigurableEnvironment environment = run.getEnvironment();
//        System.out.println(environment.getProperty("test"));
//
//        Object bean4FactoryBean = run.getBean("&bean4FactoryBean");
//        System.out.println(bean4FactoryBean);

//        new Thread(()->{
//            while (true){
//                try {
//                    Thread.sleep(1000*5);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(placeholderBean.getValue());
//            }
//        }).start();
//
//        new Thread(()->{
//            while (true){
//                try {
//                    Thread.sleep(1000*20);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                placeholderBean.setProperty1("change.........");
//            }
//        }).start();
//        String test = agent.test();
//        AServiceImpl aServiceImpl = run.getBean(AServiceImpl.class);
//        System.out.println(aServiceImpl);
//        aServiceImpl.test();
//        BServiceImpl bServiceImpl = run.getBean(BServiceImpl.class);
//        System.out.println(bServiceImpl);
//        bServiceImpl.test();

        SpringApplication.run(App.class, args);
    }
}
