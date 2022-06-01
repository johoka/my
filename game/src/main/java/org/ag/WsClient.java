package org.ag;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class WsClient extends WebSocketClient {

    public WsClient(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake arg0) {
        System.out.println("握手成功");

    }

    @Override
    public void onClose(int arg0, String arg1, boolean arg2) {
        System.out.println("连接关闭");
    }

    @Override
    public void onError(Exception arg0) {
        arg0.printStackTrace();
        System.out.println("发生错误");
    }

    @Override
    public void onMessage(String arg0) {
        System.out.println("收到字符串消息" + arg0);
    }

    @Override
    public void onMessage(ByteBuffer bytes) {
        WsClient.receiveLogin2(bytes);
    }

    public static void main(String[] args) {


//        byte[] bytes = new byte[]{0, 2, 0, 1, 0, 0, 0, 104, 0, -104, -106, -124, 0, 0, 0, 0, 0, 0, 0, 0, 114, -37, 33, -58, 32, 116, -27, 36, 31, 65, 119, -3, -75, -28, -113, 7, 0, 0, 0, 0, 98, 56, -97, 70, 0, 0, 0, 0, 49, 48, 46, 49, 57, 48, 46, 53, 46, 49, 56, 49, 58, 56, 50, 48, 51, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 50, 48, 49, 54, 55, 49, 57, 48, 48, 57, 56, 50, 48, 50, 49, 57, 0, 0, 0, 0, 0, 2, 0, 15, 0, 0, 0, 60, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 64, 118, 112, -52, -52, -52, -52, -51, 67, 78, 89, 0, 0, 0, 97, 103, 112, 104, 49, 53, 57, 50, 56, 52, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, 1};
        byte[] bytes = new byte[]{0, 11, 4, 3, 0, 0, 0, 82, 0, 0, 2, -92, 0, 0, 0, 0};

        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
//        System.out.println(byteBuffer.array().length);
//        WsClient.receiveLogin1(byteBuffer);
        //cid
        System.out.println("cid: " + byteBuffer.getInt());
        //cSize
        System.out.println("cSize: " + byteBuffer.getInt());
        //cSeq
        System.out.println("cSeq: " + byteBuffer.getInt());
        //session
        System.out.println("session: " + byteBuffer.getShort());
        //ver
        System.out.println("ver: " + byteBuffer.getShort());
    }

    private static void receiveLogin2(ByteBuffer bytes) {
        System.out.println("收到ByteBuffer消息" + Arrays.toString(bytes.array()));
    }

    private static void receiveLogin1(ByteBuffer bytes) {
        System.out.println("收到ByteBuffer消息" + bytes);
        System.out.println(Arrays.toString(bytes.array()));
        //cid
        System.out.println("cid: " + bytes.getInt());
        //cSize
        System.out.println("cSize: " + bytes.getInt());
        //cSeq
        System.out.println("cSeq: " + bytes.getInt());
        //session
        System.out.println("session: " + bytes.getShort());
        //ver
        System.out.println("ver: " + bytes.getShort());


        //code
        System.out.println("code: " + bytes.getInt());
        //token  getU(16)
        int[] tokenBytes = new int[16];
//        bytes.get(tokenBytes);
        for (int i = 0; i < tokenBytes.length; i++) {
            tokenBytes[i] = (bytes.get() & 0xFF);
        }
        System.out.println("md5: " + Arrays.toString(tokenBytes));

        //datetime
        System.out.println("datetime: " + bytes.getLong());
        //userFlag
        System.out.println("userFlag: " + bytes.getInt());
        //plazaServer
        byte[] plazaServerBytes = new byte[32];
        bytes.get(plazaServerBytes);
        System.out.println("plazaServer: " + new String(plazaServerBytes, StandardCharsets.UTF_8));
        //serverId
        byte[] serverIdBytes = new byte[4];
        bytes.get(serverIdBytes);
        System.out.println("serverId: " + new String(serverIdBytes, StandardCharsets.UTF_8));
        //uid
        byte[] uidBytes = new byte[16];
        bytes.get(uidBytes);
        System.out.println("uid: " + new String(uidBytes, StandardCharsets.UTF_8));
        //freemode
        System.out.println("freemode: " + bytes.getInt());
//        return this.code = t.getInt(),
//        this.token = t.getU(16),
//                this.datetime = t.getLong().high,
//                this.userFlag = t.getInt(),
//                this.plazaServer = Base.getString(t, 32),
//                this.serverId = Base.getString(t, 4),
//                this.uid = Base.getString(t, 16),
//                this.freemode = t.getInt(),

        System.out.println(bytes.position());
    }


}

