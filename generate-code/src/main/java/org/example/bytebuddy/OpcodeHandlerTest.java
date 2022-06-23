package org.example.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.implementation.MethodDelegation;
import org.example.*;

import java.io.File;
import java.io.IOException;

import static net.bytebuddy.matcher.ElementMatchers.named;
import static net.bytebuddy.matcher.ElementMatchers.takesArguments;

/**
 * @author 01404547
 * @date 2022/4/29
 */
public class OpcodeHandlerTest {
    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException {
        DynamicType.Unloaded<OpcodeHandler> make = new ByteBuddy()
                .subclass(OpcodeHandler.class)
                .name("org.example.bytebuddy.OpcodeHandler2")
                //代理到Target hello方法
                .method(named("match").and(takesArguments(OpcodeRequest.class, OpcodeResponse.class)))
                .intercept(MethodDelegation.to(new OpcodeHandlerInterceptor()))
//                .intercept(FixedValue.value())
                .make();
//                .load(Three.class.getClassLoader())
//                .getLoaded()
//                .newInstance()
//                .hello("World");
//        System.out.println(helloWorld);

        File file = new File("D:\\github\\my\\generate-code\\target\\classes\\");
        make.saveIn(file);

        OpcodeHandler opcodeHandler = make.load(Three.class.getClassLoader())
                .getLoaded()
                .newInstance();
        OpcodeRequest opcodeRequest = new OpcodeRequest();
        opcodeRequest.setExt1("1");
        opcodeRequest.setExt2("2");
        OpcodeResponse opcodeResponse = new OpcodeResponse();
        boolean match = opcodeHandler.match(opcodeRequest, opcodeResponse);
        System.out.println(match);
    }
}
