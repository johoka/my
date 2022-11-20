package org.example;

/**
 * @author 01404547
 * @date 2022/11/20
 */
public interface Serializer<T> {
    byte[] serialize(T ts);

    T deserialize(byte[] bytes);
}
