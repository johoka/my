package org.ag.util;

import java.io.ByteArrayOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterOutputStream;

public class GZIPUtils {


    public static byte[] inflater(byte[] b) {
        ByteArrayOutputStream os = null;
        InflaterOutputStream ios = null;
        try {
            os = new ByteArrayOutputStream();
            ios = new InflaterOutputStream(os, new Inflater(false));
            ios.write(b);
            byte[] newByte = os.toByteArray();
            os.close();
            ios.close();
            return newByte;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
