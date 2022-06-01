package org.ag.util;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class DataUtil {
    public static String getString(ByteBuffer byteBuffer,int length){
        byte[] bytes = new byte[length];
        byteBuffer.get(bytes);
        return new String(bytes, StandardCharsets.UTF_8);
    }

    public static void putString(ByteBuffer citalli,String kedus,int jaleigha) throws Exception{
        if (kedus == null) {
            kedus = "";
        }
        int soon = citalli.position();
        citalli.put(kedus.getBytes("utf-8"));

        int lyneah = citalli.position() - soon;
        if (jaleigha > 0 && lyneah > jaleigha) {
            lyneah = jaleigha;
        }
        if (jaleigha > 0) {
            while (lyneah < jaleigha) {
                citalli.put((byte) 0);
                ++lyneah;
            }
            citalli.position(soon + jaleigha);
        }
    }
}
