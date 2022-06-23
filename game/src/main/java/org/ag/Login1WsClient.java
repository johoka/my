package org.ag;

import org.ag.domain.Head;
import org.ag.decode.Decode_L2_131073;
import org.ag.receiver.ReceiverL2;
import org.ag.util.DataUtil;
import org.java_websocket.WebSocket;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.nio.ByteBuffer;

/**
 * 第一次登入websocket客户端
 * @author johoka
 */
public class Login1WsClient extends WebSocketClient {


    private final static String URL1 = "wss://ag2.cf746.com:7955/wss/tcp/YWcyLmNmNzQ2LmNvbTo4MTAx";

    public Login1WsClient(URI serverUri) {
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
    public void onMessage(ByteBuffer byteBuffer) {
        Head head = new Head();
        head.decode(byteBuffer);

        Decode_L2_131073 decodeL2131073 = new Decode_L2_131073();
        decodeL2131073.decode(byteBuffer);
        System.out.println("head:" + head.toString());
        System.out.println("body:" + decodeL2131073.toString());

        ReceiverL2.receive(decodeL2131073);
    }

    public static void login(){
        Login1WsClient wsClient = null;
        try {
            wsClient = new Login1WsClient(new URI(URL1));
            wsClient.connect();
            // 判断是否连接成功，未成功后面发送消息时会报错
            while (!wsClient.getReadyState().equals(WebSocket.READYSTATE.OPEN)) {
                System.out.println("L1连接中···请稍后");
                Thread.sleep(1000);
            }
            wsClient.sendLoginData();
            System.out.println("L1发送成功");
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(wsClient!=null){
                wsClient.close();
            }
        }
    }

    public void sendLoginData() throws Exception {
        int cId = 65537;
        int cSize = 221;
        int cSeq = 10000004;
        short session = 0;
        short ver = 2;

        ByteBuffer writeBuffer = ByteBuffer.allocate(4096);
        writeBuffer.clear();
        writeBuffer.putInt(cId);
        writeBuffer.putInt(cSize);
        writeBuffer.putInt(cSeq);
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

        DataUtil.putString(writeBuffer,name,30);
        // md5
        for (int i : md5) {
            writeBuffer.put((byte) i);
        }
        writeBuffer.putShort(deviceType);
        writeBuffer.putShort(commandType);
        DataUtil.putString(writeBuffer,version,16);
        writeBuffer.putShort(network);
        DataUtil.putString(writeBuffer,brand,16);
        DataUtil.putString(writeBuffer,mode,32);
        DataUtil.putString(writeBuffer,imei,24);
        DataUtil.putString(writeBuffer,os,16);
        DataUtil.putString(writeBuffer,resolution,16);
        DataUtil.putString(writeBuffer,carrier,32);
        writeBuffer.put(language);

        writeBuffer.flip();
        while(writeBuffer.hasRemaining()) {
            this.send(writeBuffer);
        }
    }

}
