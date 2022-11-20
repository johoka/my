package org.example.snappy;

import org.example.Compression;
import org.example.Serializer;
import org.xerial.snappy.Snappy;

import java.io.IOException;

/**
 * @author 01404547
 * @date 2022/11/20
 */
public class SnappyCompression<T> implements Compression<T> {

    private Serializer<T> defaultSerializer;

    private Serializer<T> innerSerializer;

    public SnappyCompression() {
    }

    public SnappyCompression(Serializer<T> serializer) {
        this.innerSerializer = serializer;
    }

    @Override
    public byte[] compress(T t) {
        byte[] bytes = innerSerializer != null ? innerSerializer.serialize(t)
                : defaultSerializer.serialize(t);
        try {
            return Snappy.compress(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public T decompress(byte[] bytes) {
        try {
            if (bytes == null || bytes.length <= 0) {
                return null;
            }
            byte[] bos = Snappy.uncompress(bytes);
            return (T) (innerSerializer != null ?
                    innerSerializer.deserialize(bos) : defaultSerializer.deserialize(bos));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
