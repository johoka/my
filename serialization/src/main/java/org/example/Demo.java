package org.example;

import org.example.kryo.KryoSerializer;
import org.example.protobuf.ProtostuffUtil;
import org.example.snappy.SnappyCompression;

/**
 * @author 01404547
 * @date 2022/11/20
 */
public class Demo {
    public static void main(String[] args) {
//        kryo();

        snappy();

    }

    public static void kryo(){
        Person person = new Person();
        person.setName("xbh");
        person.setAge(18);
        KryoSerializer<Person> personKryoSerializer = new KryoSerializer<>(Person.class);
        byte[] serialize = personKryoSerializer.serialize(person);
        Person deserialize = personKryoSerializer.deserialize(serialize);
        System.out.println(deserialize.getName());
        System.out.println(deserialize.getAge());

//        SnappyCompression<Person> personSnappyCompression = new SnappyCompression<>(personKryoSerializer);
//        byte[] compress = personSnappyCompression.compress(person);
//        Person decompress = personSnappyCompression.decompress(compress);
//        System.out.println(decompress.getName());
    }

    public static void snappy(){
        Person person = new Person();
        person.setName("xbh");
        person.setAge(18);

        byte[] serializer = ProtostuffUtil.serializer(person);
        Person deserializer = ProtostuffUtil.deserializer(serializer, Person.class);
        System.out.println(deserializer);
    }
}
