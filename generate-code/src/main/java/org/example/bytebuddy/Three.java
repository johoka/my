package org.example.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.MethodDelegation;
import org.example.Source;
import org.example.Target;

import java.io.File;
import java.io.IOException;

import static net.bytebuddy.matcher.ElementMatchers.named;

/**
 * @author 01404547
 * @date 2022/4/29
 */
public class Three {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IOException {
        DynamicType.Unloaded<Source> make = new ByteBuddy()
                .subclass(Source.class)
                .name("org.example.bytebuddy.MyClassName3")
                //代理到Target hello方法
                .method(named("hello")).intercept(MethodDelegation.to(Target.class))
                .make();
//                .load(Three.class.getClassLoader())
//                .getLoaded()
//                .newInstance()
//                .hello("World");
//        System.out.println(helloWorld);

        File file = new File("D:\\github\\my\\generate-code\\target\\classes\\");
        make.saveIn(file);
    }
}
