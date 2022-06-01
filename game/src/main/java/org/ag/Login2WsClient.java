package org.ag;

import org.ag.constant.ConnectInfo;
import org.ag.decode.Decode_P26_721928;
import org.ag.decode.Decode_P4_721922;
import org.ag.decode.Decode721923;
import org.ag.domain.Head;
import org.ag.receiver.ReceiverP26;
import org.ag.util.DataUtil;
import org.java_websocket.WebSocket;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * 第二次登入客户端，由第一次登入触发
 * @author johoka
 */
public class Login2WsClient extends WebSocketClient {

    private ByteBuffer recvBuf = ByteBuffer.allocate(262144);
    private int wPosition = 0;
    private int rPosition = 0;
    private Head head = new Head();
    private boolean isHead = true;

    public static Login2WsClient instance;

//    private final static String URL = "wss://ag2.cf746.com:7955/wss/tcp/YWcyLmNmNzQ2LmNvbTo4MjA0";
//    private final static String URL = "ws://127.0.0.1:8080/websocket/wupx";
    private final static String URL = "wss://ag2.cf746.com:7955/wss/tcp/YWcyLmNmNzQ2LmNvbTo4MjAx";


    int i = 0;

    public Login2WsClient(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake arg0) {
        System.out.println("L2握手成功");

    }

    @Override
    public void onClose(int arg0, String arg1, boolean arg2) {
        System.out.println("L2连接关闭");
    }

    @Override
    public void onError(Exception arg0) {
        arg0.printStackTrace();
        System.out.println("L2发生错误");
    }

    @Override
    public void onMessage(String arg0) {
        System.out.println("收到字符串消息" + arg0);
    }

    @Override
    public void onMessage(ByteBuffer byteBuffer) {
        int remaining1 = recvBuf.remaining();
        System.out.println("recvBuf未读取数量：" + remaining1);
        System.out.println("wPosition写入位置：" + wPosition);
        if(wPosition > 1024*10){
            //写入的地方大于10M时，重置recvBuf
            recvBuf.compact();
        }
        //剩余未读取
        int remaining = byteBuffer.remaining();
        byte[] bodyPkg = new byte[remaining];
        byteBuffer.get(bodyPkg);
        recvBuf.position(wPosition);
        recvBuf.put(bodyPkg);
        //记录写position
        wPosition = recvBuf.position();
        if(isHead){
            recvBuf.position(rPosition);
            this.head.decode(recvBuf);
            //记录新的position
            rPosition = recvBuf.position();
        }
        int unRead = wPosition - rPosition;
        if(head.getCSize() <= (unRead + head.getHeadLength())){
            //开始从recvBuf decode数据
            this.isHead = true;
            recvBuf.position(rPosition);
            decodeBody(recvBuf);
            rPosition = recvBuf.position();
        }else{
            this.isHead = false;
        }
    }

    private void decodeBody(ByteBuffer byteBuffer){

        int bodyPkgLength = head.getCSize() - head.getHeadLength();
        byte[] bytes = new byte[bodyPkgLength];
        byteBuffer.get(bytes);

        ByteBuffer newByteBuffer = ByteBuffer.wrap(bytes);

        if(head.getCid() == 721923){
            Decode721923 decode721923 = new Decode721923();
            decode721923.decode(newByteBuffer);
//            System.out.println(decode721923);
            return;
        }else if(head.getCid() == 380930){
//            System.out.println(byteBuffer);
            return;
        }else if(head.getCid() == 721922){
            System.out.println("721922: " + newByteBuffer);
            Decode_P4_721922 decodeP4721922 = new Decode_P4_721922();
            decodeP4721922.decode(newByteBuffer);
            return;
        }else if(head.getCid() == 721928){
            Decode_P26_721928 decode_p26_721928 = new Decode_P26_721928();
            decode_p26_721928.decode(newByteBuffer);
            System.out.println(decode_p26_721928);

            ReceiverP26.receive(decode_p26_721928);

        }
    }

    public static void login(int[] token){
        try {
            System.out.println("token: " + Arrays.toString(token));
            instance = new Login2WsClient(new URI(URL));
            instance.connect();
            // 判断是否连接成功，未成功后面发送消息时会报错
            while (!instance.getReadyState().equals(WebSocket.READYSTATE.OPEN)) {
                System.out.println("L2连接中···请稍后");
                Thread.sleep(1000);
            }
            instance.sendLoginData(token);
            System.out.println("L2发送成功");
            Thread.sleep(100000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(instance !=null){
                instance.close();
            }
        }
    }

    public void sendLoginData(int[] token) throws Exception {
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
        int[] md5 = token;
        byte type = 70;
        byte language = 0;

        DataUtil.putString(writeBuffer,name,30);
        for (int i : md5) {
            writeBuffer.put((byte) i);
        }
        writeBuffer.put(type);
        writeBuffer.put(language);

        writeBuffer.flip();
        while(writeBuffer.hasRemaining()) {
            this.send(writeBuffer);
        }

        Thread.sleep(1000*8);

//        GameManager.requestGameSvr(ConnectInfo.TEST_VID);
//
//
//        ByteBuffer inTableBuffer = ByteBuffer.allocate(24);
//        Head head = new Head();
//        head.setCid(65648);
//        head.setCSize(24);
//        head.setCSeq(10000021);
//        head.setSession((short) 0);
//        head.setVer((short) 2);
//
//        AutoInTableEncode autoInTableEncode = new AutoInTableEncode();
//
//        autoInTableEncode.setOddtype("A");
//        autoInTableEncode.setVid("B005");
//
//        head.encode(inTableBuffer);
//        autoInTableEncode.encode(inTableBuffer);
//
//        inTableBuffer.flip();
//        while(inTableBuffer.hasRemaining()) {
//            this.send(inTableBuffer);
//        }

    }

    public static void main(String[] args) {
//        int[] token = new int[]{182, 180, 116, 234, 228, 27, 176, 8, 219, 46, 34, 209, 113, 139, 218, 43};
//        login(token);
    }

}
