package org.ag.decode;

import lombok.Getter;
import lombok.Setter;
import org.ag.util.DataUtil;

import java.nio.ByteBuffer;

/**
 * 获取房间信息，和P4组合成更详细的房间信息，该类可以知道房间玩的人数
 * @author johoka
 */
@Getter
@Setter
public class Decode721923 implements Decode{

    private String roomid;
    private String gameType;
    /**
     * 房间信息，eg，B005
     */
    private String vid;
    /**
     * peopleNum
     */
    private Short num;
    /**
     * betNum
     */
    private Short bnum;
    /**
     * playPNum
     */
    private Short n1;
    /**
     * bankPNum
     */
    private Short n2;
    /**
     * playTotal
     */
    private Float credit1;
    /**
     * bankTotal
     */
    private Float credit2;
    private Short n3;
    private Short n4;
    private Short n5;
    private Short n6;
    private Short n7;
    private Float credit3;
    private Float credit4;
    private Float credit5;
    private Float credit6;
    private Float credit7;
    /**
     * upTableTotal
     */
    private Double totalbal;

    @Override
    public int getCmd() {
        return 721923;
    }

    @Override
    public Decode721923 decode(ByteBuffer byteBuffer){
        this.roomid = DataUtil.getString(byteBuffer,4);
        this.gameType = DataUtil.getString(byteBuffer,4);
        this.vid = DataUtil.getString(byteBuffer,4);
        this.num = byteBuffer.getShort();
        if(GameType.isBAC(gameType)
            || GameType.GT_TIGER.equals(gameType)
            || GameType.GT_DICE.equals(gameType)){
            this.bnum = byteBuffer.getShort();
            this.n1 = byteBuffer.getShort();
            this.n2 = byteBuffer.getShort();
            this.credit1 = byteBuffer.getFloat();
            this.credit2 = byteBuffer.getFloat();
            this.n3 = byteBuffer.getShort();
            this.n4 = byteBuffer.getShort();
            this.n5 = byteBuffer.getShort();
            this.n6 = byteBuffer.getShort();
            this.n7 = byteBuffer.getShort();
            this.credit3 = byteBuffer.getFloat();
            this.credit4 = byteBuffer.getFloat();
            this.credit5 = byteBuffer.getFloat();
            this.credit6 = byteBuffer.getFloat();
            this.credit7 = byteBuffer.getFloat();
            this.totalbal = byteBuffer.getDouble();
        }else if(GameType.GT_ZJH.equals(gameType)){
            this.n1 = byteBuffer.getShort();
            this.n2 = byteBuffer.getShort();
            this.credit1 = byteBuffer.getFloat();
            this.credit2 = byteBuffer.getFloat();
            this.totalbal = byteBuffer.getDouble();
        }else if(GameType.GT_BF.equals(gameType)){
            this.n1 = byteBuffer.getShort();
            this.n2 = byteBuffer.getShort();
            this.credit1 = byteBuffer.getFloat();
            this.credit2 = byteBuffer.getFloat();
            this.totalbal = byteBuffer.getDouble();
        }else if(GameType.GT_NN.equals(gameType)){
//            this.n2 = t.readShort(),
//            this.n1 = t.readShort(),
//            this.credit2 = t.readFloat(),
//            this.credit1 = t.readFloat(),
//            this.totalbal = t.getDouble()
        }else if(GameType.GT_DISH.equals(gameType)){
//            this.bnum = t.readShort(),
//            this.n2 = t.readShort(),
//            this.n1 = t.readShort(),
//            this.n3 = t.readShort(),
//            this.n4 = t.readShort(),
//            this.n5 = t.readShort(),
//            this.n6 = t.readShort(),
//            this.credit2 = t.readFloat(),
//            this.credit1 = t.readFloat(),
//            this.credit3 = t.readFloat(),
//            this.credit4 = t.readFloat(),
//            this.credit5 = t.readFloat(),
//            this.credit6 = t.readFloat(),
//            this.totalbal = t.getDouble()
        }

        return this;
    }


//            this.roomid = Base.getString(t, 4);
//    var e = this.gameType = Base.getString(t, 4);
//        return this.vid = Base.getString(t, 4),
//            this.num = t.getShort(),
//            GameType.isBAC(e) || e == GameType.GT_TIGER || e == GameType.GT_DICE ? (this.bnum = t.getShort(),
//            this.n1 = t.getShort(),
//            this.n2 = t.getShort(),
//            this.credit1 = t.getFloat(),
//            this.credit2 = t.getFloat(),
//            this.n3 = t.getShort(),
//            this.n4 = t.getShort(),
//            this.n5 = t.getShort(),
//            this.n6 = t.getShort(),
//            this.n7 = t.getShort(),
//            this.credit3 = t.getFloat(),
//            this.credit4 = t.getFloat(),
//            this.credit5 = t.getFloat(),
//            this.credit6 = t.getFloat(),
//            this.credit7 = t.getFloat(),
//            this.totalbal = t.getDouble()) : e == GameType.GT_ZJH ? (this.n1 = t.getShort(),
//            this.n2 = t.getShort(),
//            this.credit1 = t.getFloat(),
//            this.credit2 = t.getFloat(),
//            this.totalbal = t.getDouble()) : e == GameType.GT_BF ? (this.n1 = t.getShort(),
//            this.n2 = t.getShort(),
//            this.credit1 = t.getFloat(),
//            this.credit2 = t.getFloat(),
//            this.totalbal = t.getDouble()) : e == GameType.GT_NN ? (this.n2 = t.readShort(),
//            this.n1 = t.readShort(),
//            this.credit2 = t.readFloat(),
//            this.credit1 = t.readFloat(),
//            this.totalbal = t.getDouble()) : e == GameType.GT_DISH && (this.bnum = t.readShort(),
//            this.n2 = t.readShort(),
//            this.n1 = t.readShort(),
//            this.n3 = t.readShort(),
//            this.n4 = t.readShort(),
//            this.n5 = t.readShort(),
//            this.n6 = t.readShort(),
//            this.credit2 = t.readFloat(),
//            this.credit1 = t.readFloat(),
//            this.credit3 = t.readFloat(),
//            this.credit4 = t.readFloat(),
//            this.credit5 = t.readFloat(),
//            this.credit6 = t.readFloat(),
//            this.totalbal = t.getDouble()),


    @Override
    public String toString() {
        return "Decode721923{" +
                "roomid='" + roomid + '\'' +
                ", gameType='" + gameType + '\'' +
                ", vid='" + vid + '\'' +
                ", num=" + num +
                ", bnum=" + bnum +
                ", n1=" + n1 +
                ", n2=" + n2 +
                ", credit1=" + credit1 +
                ", credit2=" + credit2 +
                ", n3=" + n3 +
                ", n4=" + n4 +
                ", n5=" + n5 +
                ", n6=" + n6 +
                ", n7=" + n7 +
                ", credit3=" + credit3 +
                ", credit4=" + credit4 +
                ", credit5=" + credit5 +
                ", credit6=" + credit6 +
                ", credit7=" + credit7 +
                ", totalbal=" + totalbal +
                '}';
    }
}
