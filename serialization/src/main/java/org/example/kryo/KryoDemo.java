package org.example.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import org.example.Person;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author 01404547
 * @date 2022/11/20
 */
public class KryoDemo {
    public static void main(String[] args) throws FileNotFoundException {
        Kryo kryo = new Kryo();



        kryo.register(Person.class);

        Person person = new Person();
        person.setName("kryo!");

        Output output = new Output(new FileOutputStream("D:\\kryo"));
        kryo.writeObject(output, person);
        output.close();

        Input input = new Input(new FileInputStream("D:\\kryo"));
        Person object2 = kryo.readObject(input, Person.class);
        input.close();
        System.out.println(object2.getName());
    }
}
