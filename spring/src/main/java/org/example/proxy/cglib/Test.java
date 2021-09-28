package org.example.proxy.cglib;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {

    public static void main(String[] args) {
        //动态class存放地址，方便反编译分析
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/johoka/IdeaProjects/my/spring/src/main/java/org/example/proxy/cglib");
        Enhancer enhancer = new Enhancer();
        // 设置目标类
        enhancer.setSuperclass(Target.class);
        // 设置拦截器对象
        enhancer.setCallback(new MyInterceptor());
        // 创建子类 即代理
        Target targetClassProxy = (Target) enhancer.create();
//        try {
//            Field field1 = targetClassProxy.getClass().getField("field1");
//            try {
//                Object o = field1.get(targetClassProxy);
//                System.out.println(o);
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }
        targetClassProxy.method1();

    }

    static class MyInterceptor implements MethodInterceptor {

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("------插入前置通知代码-------------");
            // 此处一定要使用proxy的invokeSuper方法来调用目标类的方法
            methodProxy.invokeSuper(o, objects);
            System.out.println("------插入后置处理代码-------------");
            return null;
        }
    }
}
