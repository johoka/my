package org.ag;

import org.java_websocket.WebSocket;
import sun.rmi.runtime.Log;

import java.net.URI;

public class AgWebScoketClient {

//    "wss://ag2.cf746.com:7955/wss/tcp/YWcyLmNmNzQ2LmNvbTo4MTAx"
    private final static String URL1 = "wss://ag2.cf746.com:7955/wss/tcp/YWcyLmNmNzQ2LmNvbTo4MTAx";
    private final static String URL2 = "wss://ag2.cf746.com:7955/wss/tcp/YWcyLmNmNzQ2LmNvbTo4MjA0";

//    private final static String URL3 = "ws://127.0.0.1:8080/websocket/wupx";

    public static void main(String[] args) {
        Login1WsClient.login();
    }

//    public static void sendLogin1(){
//        Login1WsClient login1WsClient = null;
//        try {
//            login1WsClient = new Login1WsClient(new URI(URL1));
//            login1WsClient.connect();
//            // 判断是否连接成功，未成功后面发送消息时会报错
//            while (!login1WsClient.getReadyState().equals(WebSocket.READYSTATE.OPEN)) {
//                System.out.println("连接中···请稍后");
//                Thread.sleep(1000);
//            }
//            login1WsClient.sendLoginData();
//            System.out.println("发送成功");
//            Thread.sleep(5000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if(login1WsClient!=null){
//                login1WsClient.close();
//            }
//        }
//    }
//
//    public static void sendLogin2(){
//        WsClient myClient = null;
//        try {
//            myClient = new WsClient(new URI(URL2));
//            myClient.connect();
//            // 判断是否连接成功，未成功后面发送消息时会报错
//            while (!myClient.getReadyState().equals(WebSocket.READYSTATE.OPEN)) {
//                System.out.println("连接中···请稍后");
//                Thread.sleep(1000);
//            }
//            LoginData.sendLogin2(myClient);
////            myClient.send("1");
//            System.out.println("发送成功");
//            Thread.sleep(100000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if(myClient!=null){
//                myClient.close();
//            }
//        }
//    }

}



