package org.ag;

import org.ag.decode.Decode721923;
import org.ag.decode.Decode_D10_380930;
import org.ag.decode.Decode_P26_721928;
import org.ag.decode.Decode_P4_721922;
import org.ag.domain.Head;
import org.ag.receiver.ReceiverP26;
import org.java_websocket.WebSocket;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.nio.ByteBuffer;

/**
 * @author johoka
 */
public class GameWsClient extends WebSocketClient {

    private ByteBuffer recvBuf = ByteBuffer.allocate(262144);
    private int wPosition = 0;
    private int rPosition = 0;
    private Head head = new Head();
    private boolean isHead = true;

    public GameWsClient(URI serverUri) {
        super(serverUri);
    }


    @Override
    public void onOpen(ServerHandshake handshakedata) {
        System.out.println("GameWsClient已经连接上");
    }

    @Override
    public void onMessage(String message) {
        System.out.println("收到字符串消息");
    }

    @Override
    public void onMessage(ByteBuffer byteBuffer){
//        System.out.println("GameWsClient 收到byteBuffer消息");

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
        System.out.println(head.getCid());
        if(head.getCid() == 380930){
            Decode_D10_380930 decode_d10_380930 = new Decode_D10_380930();
            decode_d10_380930.decode(newByteBuffer);
            System.out.println(decode_d10_380930);
        }



    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("关闭");
    }

    @Override
    public void onError(Exception ex) {
        ex.printStackTrace();
    }

}
