package org.example;

/**
 * @author 01404547
 * @date 2022/4/29
 */
public interface OpcodeHandler {
    String opcode(OpcodeRequest request);

    default boolean match(OpcodeRequest request) { return true;}

    default boolean match(OpcodeRequest request, OpcodeResponse response) { return match(request);}

    default void doHandle(OpcodeRequest request, OpcodeResponse response) {}
}
