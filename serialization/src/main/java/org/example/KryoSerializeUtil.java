package org.example;

import com.esotericsoftware.kryo.Kryo;

/**
 * @author 01404547
 * @date 2022/11/20
 */
public final class KryoSerializeUtil {
    /**Kryo对象线程不安全，但是能加快序列化和反序列的速度*/
    public static  final ThreadLocal<Kryo> tLocal = new ThreadLocal<Kryo>() {
        protected Kryo initialValue() {
            Kryo kryo = new Kryo();
            kryo.setRegistrationRequired(false);
            return kryo;
        };
    };

}

