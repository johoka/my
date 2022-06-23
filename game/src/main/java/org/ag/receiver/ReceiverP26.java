package org.ag.receiver;

import org.ag.GameManager;
import org.ag.decode.Decode_P26_721928;
import org.ag.domain.room.Room;
import org.ag.domain.room.Video;

public class ReceiverP26 {

    public static void receive(Decode_P26_721928 p26){
        String vid = p26.getVid();
        int code = p26.getCode();
        String gameSvrId = p26.getGameSvrId();
        String gameSvrIp = p26.getGameSvrIp();

//        if(0 != code){
////            return this.setGoingInTable(false), undefined;
//            return;
//        }
//        //todo 根据vid获取房间号
//        Room room = null;
//        if(room ==null){
////            return undefined;
//            return;
//        }
//        Video video = room.getVideo();
//        if(video ==null){
////            return undefined;
//            return;
//        }
        System.out.println("game 新游戏服务器Id地址：" + gameSvrId);
//        GameManager.loginGame(gameSvrIp,video.getGms());
        //todo gms暂时传空
        GameManager.loginGame(gameSvrIp,null);

    }
}
