package org.ag.encode;

import java.nio.ByteBuffer;

/**
 * 编码
 * @author johoka
 */
public interface Encode {
    void encode(ByteBuffer byteBuffer) throws Exception;
}
