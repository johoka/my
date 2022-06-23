package org.example;

/**
 * @author 01404547
 * @date 2022/4/29
 */
public class GreetingInterceptor {
    public Object greet(Object argument) {
        return "Hello from " + argument;
    }

}
