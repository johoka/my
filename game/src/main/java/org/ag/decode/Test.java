package org.ag.decode;

import org.ag.util.DataUtil;
import org.ag.domain.Head;

import java.nio.ByteBuffer;

public class Test {
    static byte[] data = new byte[]{
             0,
             11,
             4,
             3,
             0,
             0,
             0,
             82,
             0,
             0,
             16,
             32,
             0,
             0,
             0,
             0,
             66,
             48,
             48,
             52,
             66,
             65,
             67,
             0,
             66,
             48,
             48,
             52,
             0,
             30,
             0,
             14,
             0,
             6,
             0,
             6,
             68,
             37,
             45,
             -73,
             69,
             75,
             62,
             122,
             0,
             0,
             0,
             2,
             0,
             2,
             0,
             0,
             0,
             0,
             0,
             0,
             0,
             0,
             66,
             94,
             -37,
             110,
             66,
             94,
             -37,
             110,
             0,
             0,
             0,
             0,
             0,
             0,
             0,
             0,
             64,
             -34,
             -98,
             -11,
             103,
             41,
             44,
             -28
    };


    public static void main(String[] args) {

        ByteBuffer byteBuffer = ByteBuffer.wrap(data);

        Head head = new Head();
        head.decode(byteBuffer);
        System.out.println(head.toString());
        System.out.println(DataUtil.getString(byteBuffer,4));

//        String str = "B004";
//        System.out.println(Arrays.toString(str.getBytes(StandardCharsets.UTF_8)));

    }

}
