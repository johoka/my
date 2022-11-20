package org.example.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import org.example.KryoSerializeUtil;
import org.example.Serializer;

import java.io.ByteArrayOutputStream;

/**
 * @author 01404547
 * @date 2022/11/20
 */
public class KryoSerializer<T> implements Serializer<T> {

    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    private Class<T> clazz;

    public KryoSerializer(Class<T> clazz ){
        this.clazz = clazz;
    }

    @Override
    public byte[] serialize(T t) {
        if (t == null) {
            return EMPTY_BYTE_ARRAY;
        }
        Kryo kryo = KryoSerializeUtil.tLocal.get();
        kryo.setReferences(false);
        kryo.register(clazz);
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             Output output = new Output(baos)) {
            kryo.writeClassAndObject(output, t);
            output.flush();
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return EMPTY_BYTE_ARRAY;
    }

    @Override
    public T deserialize(byte[] bytes) {
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        Kryo kryo = KryoSerializeUtil.tLocal.get();
        kryo.setReferences(false);
        kryo.register(clazz);
        try (Input input = new Input(bytes)) {
            return kryo.readObject(input,clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
