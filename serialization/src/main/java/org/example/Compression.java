package org.example;

/**
 * @author 01404547
 * @date 2022/11/20
 */
public interface Compression<T> {

    byte[] compress(T ts);

    T decompress(byte[] bytes);
}
