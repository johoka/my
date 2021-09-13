package org.example.circularreferences;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;


@Component
public class DestoryCircularBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        if(beanName.equals("BServiceImpl")){
//            System.out.println("修改前bean:" + bean);
//            BServiceImpl bService = new BServiceImpl();
//            System.out.println("修改后bean:" + bService);
//            return bService;
//        }
        return bean;
    }
}
