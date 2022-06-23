package org.example.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import org.example.GreetingInterceptor;
import org.example.OpcodeHandler;

import java.io.File;
import java.io.IOException;
import java.util.function.Function;

/**
 * @author 01404547
 * @date 2022/4/29
 */
public class Four {
    public static void main(String[] args) throws IOException {
        DynamicType.Unloaded<Function> make = new ByteBuddy()
                .subclass(java.util.function.Function.class)
                .name("org.example.bytebuddy.FunctionTest")
                .method(ElementMatchers.named("apply"))
                .intercept(MethodDelegation.to(new GreetingInterceptor()))
                .make();

        File file = new File("D:\\github\\my\\generate-code\\target\\classes\\");
        make.saveIn(file);
    }
}
