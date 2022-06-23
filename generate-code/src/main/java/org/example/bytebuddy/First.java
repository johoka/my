package org.example.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import org.example.OpcodeHandler;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import static net.bytebuddy.matcher.ElementMatchers.named;

/**
 * @author 01404547
 * @date 2022/4/29
 */
public class First {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IOException {
//        Object obj = new ByteBuddy()
//                .subclass(Object.class)
//                .name("org.example.bytebuddy.MyClassName")
//                .method(ElementMatchers.isToString())
//                .intercept(FixedValue.value("Hello World ByteBuddy!"))
//                .make()
//                .load(First.class.getClassLoader())
//                .getLoaded()
//                .newInstance();
//        System.out.println(obj.getClass());

        DynamicType.Unloaded<?> dynamicType = new ByteBuddy()
                .subclass(OpcodeHandler.class)
                .name("org.example.bytebuddy.MyClassName1")
                .method(named("opcode"))
                .intercept(FixedValue.value("Hello World ByteBuddy!"))
                .method(named("match"))
                .intercept(FixedValue.value(true))
                .method(named("doHandle"))
                .intercept(FixedValue.value("Hello World ByteBuddy!"))

                .make();
        File file = new File("D:\\github\\my\\generate-code\\target\\classes\\");
        dynamicType.saveIn(file);
    }


    static class Foo {
        public String sayHelloFoo() {
            return "Hello in Foo!";
        }
    }

    static class Bar {
        public String sayHelloBar() {
            return "Hello in Bar!";
        }
    }


}
