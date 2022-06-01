package org.ag;

import java.nio.ByteBuffer;

public class LoginData {

    static void sendLogin1(WsClient wsClient) throws Exception{

        int cId = 65537;
        int cSeq = 221;
        int cSize = 10000004;
        short session = 0;
        short ver = 2;

        ByteBuffer writeBuffer = ByteBuffer.allocate(4096);
        writeBuffer.clear();
        writeBuffer.putInt(cId);
        writeBuffer.putInt(cSeq);
        writeBuffer.putInt(cSize);
        writeBuffer.putShort(session);
        writeBuffer.putShort(ver);

        String name = "HC6agph159284";
//            md5 不知道给什么类型,大概率应该是byte
        int[] md5 = new int[]{120,151,244,9,42,56,48,235,21,13,162,50,191,168,90,200};
        short deviceType = 70;
        short commandType = 104;
        String version = "v3.172.79.130";
        short network = 3;
        String brand = "";
        String mode = "";
        String imei = "";
        String os="";
        String resolution = "";
        String carrier = "";
        byte language = 0;

        putString(writeBuffer,name,30);
        // md5
        for (int i : md5) {
            writeBuffer.put((byte) i);
        }
        writeBuffer.putShort(deviceType);
        writeBuffer.putShort(commandType);
        putString(writeBuffer,version,16);
        writeBuffer.putShort(network);
        putString(writeBuffer,brand,16);
        putString(writeBuffer,mode,32);
        putString(writeBuffer,imei,24);
        putString(writeBuffer,os,16);
        putString(writeBuffer,resolution,16);
        putString(writeBuffer,carrier,32);
        writeBuffer.put(language);

        writeBuffer.flip();
        while(writeBuffer.hasRemaining()) {
            wsClient.send(writeBuffer);
        }
    }

    public static void sendLogin2(WsClient wsClient) throws Exception{

        int cId = 263681;
        int cSeq = 64;
        int cSize = 10000005;
        short session = 0;
        short ver = 2;

        ByteBuffer writeBuffer = ByteBuffer.allocate(4096);
        writeBuffer.clear();
        writeBuffer.putInt(cId);
        writeBuffer.putInt(cSeq);
        writeBuffer.putInt(cSize);
        writeBuffer.putShort(session);
        writeBuffer.putShort(ver);


        String name = "HC6agph159284";
        //md5 unit8Array 16
        int[] md5 = new int[]{20, 54, 167, 219, 70, 153, 99, 57, 121, 172, 241, 224, 211, 9, 9, 26};
        byte type = 70;
        byte language = 0;

        putString(writeBuffer,name,30);
        for (int i : md5) {
            writeBuffer.put((byte) i);
        }
        writeBuffer.put(type);
        writeBuffer.put(language);

        writeBuffer.flip();
        while(writeBuffer.hasRemaining()) {
            wsClient.send(writeBuffer);
        }
    }

    private static void putString(ByteBuffer citalli,String kedus,int jaleigha) throws Exception{
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
