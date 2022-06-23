package org.example.bytebuddy;

import net.bytebuddy.implementation.bind.annotation.Argument;
import org.example.OpcodeHandler;
import org.example.OpcodeRequest;
import org.example.OpcodeResponse;

/**
 * @author 01404547
 * @date 2022/4/29
 */
public class OpcodeHandlerInterceptor {

    private String source = "ext1.equals(\"1\");";

    public  boolean match(OpcodeRequest opcodeRequest, OpcodeResponse opcodeResponse) {
        return true;
    }
}
