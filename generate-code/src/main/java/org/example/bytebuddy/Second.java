package org.example.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import org.example.Foo;

import java.io.File;
import java.io.IOException;

import static net.bytebuddy.matcher.ElementMatchers.*;

/**
 * @author 01404547
 * @date 2022/4/29
 */
public class Second {
    public static void main(String[] args) throws IOException {
        DynamicType.Unloaded<Foo> make = new ByteBuddy()
                .subclass(Foo.class)
                .name("org.example.bytebuddy.MyClassName2")
                .method(isDeclaredBy(Foo.class)).intercept(FixedValue.value("One!"))
                .method(named("foo")).intercept(FixedValue.value("Two!"))
                //takesArguments 选择参数类型，主要用于区别重载
                .method(named("foo").and(takesArguments(1))).intercept(FixedValue.value("Three!"))
                .make();

        File file = new File("D:\\github\\my\\generate-code\\target\\classes\\");
        make.saveIn(file);
    }
}
