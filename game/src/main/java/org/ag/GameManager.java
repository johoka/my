package org.ag;

import org.ag.constant.ConnectInfo;
import org.ag.domain.room.Room;
import org.ag.encode.Eecode_P25_263176;
import org.ag.encode.Encode_G1_69633;
import org.ag.encode.Encode_G21_65648;
import org.java_websocket.WebSocket;
import org.java_websocket.util.Base64;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public class GameManager {

    private static  Map<String,GameWsClient> gameMap = new HashMap<>();

    public static void requestGameSvr(String vid){
        ByteBuffer byteBuffer = ByteBuffer.allocate(24);
//        //通过room获取gms
//        Room room = null;
        Eecode_P25_263176 eecode_p25_263176 = new Eecode_P25_263176(vid);
        try {
            eecode_p25_263176.encode(byteBuffer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        byteBuffer.flip();
        Login2WsClient.instance.send(byteBuffer);
    }

    public static void loginGame(String gameSvrIp, String gms){
        try {
            String[] ipPort = gameSvrIp.split(":");
            if(ipPort.length !=2){
                return;
            }
            String host  = ConnectInfo.GAME_HOST + ":" + ipPort[1].trim();
            String path = ConnectInfo.WS_PATH + Base64.encodeBytes(host.getBytes());
            String url = ConnectInfo.WS_HOST + path;

            URI uri = new URI(url);
            GameWsClient gameWsClient = gameMap.get(url);
            if(gameWsClient == null){
                //url没有匹配登入信息，新建登入信息
                gameWsClient = new GameWsClient(uri);
                gameWsClient.connect();
                gameMap.put(url,gameWsClient);
            }
            // 判断是否连接成功，未成功后面发送消息时会报错
            while (!gameWsClient.getReadyState().equals(WebSocket.READYSTATE.OPEN)) {
                System.out.println("正在连接具体游戏...");
                Thread.sleep(1000);
            }
            //发送登入信息

            ByteBuffer byteBuffer = ByteBuffer.allocate(63);
            Encode_G1_69633 encode_g1_69633 = new Encode_G1_69633();
            encode_g1_69633.setName(UserManage.name);
            encode_g1_69633.setToken(UserManage.mToken);
            encode_g1_69633.encode(byteBuffer);
            byteBuffer.flip();
            gameWsClient.send(byteBuffer);

            //进入牌桌
            ByteBuffer encode_g21_65648_byteBuffer = ByteBuffer.allocate(24);
            Encode_G21_65648 encode_g21_65648 = new Encode_G21_65648();
            encode_g21_65648.setVid(ConnectInfo.TEST_VID);
            encode_g21_65648.encode(encode_g21_65648_byteBuffer);
            encode_g21_65648_byteBuffer.flip();
            gameWsClient.send(encode_g21_65648_byteBuffer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
//        String url = "wss://ag2.cf746.com:7955/wss/tcp/YWcyLmNmNzQ2LmNvbTo4MzAy";
//        String url = "wss://ag2.cf746.com:8302/wss/tcp/d3NzOi8vYWcyLmNmNzQ2LmNvbTo4MzAy";
//        String url = "wss://ag2.cf746.com:7955/wss/tcp/YWcyLmNmNzQ2LmNvbTo4MzAx";

        String url = "ws://127.0.0.1:8080/websocket/wupx";

        GameWsClient gameWsClient = new GameWsClient(new URI(url));
        gameWsClient.connect();
        // 判断是否连接成功，未成功后面发送消息时会报错
        while (!gameWsClient.getReadyState().equals(WebSocket.READYSTATE.OPEN)) {
            System.out.println("正在连接具体游戏...");
            Thread.sleep(1000);
        }

        ByteBuffer byteBuffer = ByteBuffer.allocate(63);
        Encode_G1_69633 encode_g1_69633 = new Encode_G1_69633();
        encode_g1_69633.setName(UserManage.name);
        encode_g1_69633.setToken(new int[]{199, 60, 221, 237, 149, 147, 25, 15, 170, 166, 139, 214, 0, 3, 115, 44});
        encode_g1_69633.encode(byteBuffer);
        byteBuffer.flip();
        gameWsClient.send(byteBuffer);

    }
}
