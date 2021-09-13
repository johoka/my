package org.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectTest {

//    @Pointcut("execution(* org.example.aspect.Agent.*(..))")
    @Pointcut("execution(* org.example.circularreferences.AServiceImpl.*(..)) || execution(* org.example.circularreferences.BServiceImpl.*(..))")
    public void pointcut(){

    }

    @Around(value = "pointcut()")
    public Object around(final ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("开始执行");
        Object proceed = pjp.proceed();
        System.out.println("执行结束");
        return proceed;
    }
}
