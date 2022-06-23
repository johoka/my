package org.ag.test;

import java.nio.ByteBuffer;

/**
 * @author johoka
 */
public class ByteBufferTest {
    public static void main(String[] args) {
        ByteBuffer recvBuf = ByteBuffer.allocate(64);
//        System.out.println("recvBuf" + recvBuf);
        ByteBuffer byteBuffer = ByteBuffer.allocate(16);
        byteBuffer.put((byte) 1);
        byteBuffer.put((byte) 2);
        System.out.println(byteBuffer);
        byteBuffer.flip();
        System.out.println("byteBuffer:" + byteBuffer.remaining());
        recvBuf.put(byteBuffer.array());
        System.out.println("recvBuf:" + recvBuf);
        recvBuf.flip();
        System.out.println("recvBuf:" + recvBuf);
        System.out.println(recvBuf.get());
        System.out.println("recvBuf:" + recvBuf);
        recvBuf.clear();
        System.out.println("recvBuf:" + recvBuf);

    }
}
