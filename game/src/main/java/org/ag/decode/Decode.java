package org.ag.decode;

import java.nio.ByteBuffer;

public interface Decode {
    int getCmd();

    Decode decode(ByteBuffer byteBuffer);
}
