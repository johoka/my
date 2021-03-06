package org.ag.decode;

import org.ag.util.DataUtil;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * 牌信息
 * @author johoka
 */
public class Decode_D10_380930 implements Decode {
    /**
     * 游戏编码，唯一，eg.GB003223250R4 
     */
    private String gmcode;
    /**
     * 房间号,eg.B003
     */
    private String vid;
    /**
     * 点数（需要转换成牌）
     */
    private byte card;
    /**
     * 牌显示顺序
     */
    private byte index;
    /**
     * 不知道是什么，观察到的一直是1
     */
    private byte show;
    /**
     * 庄，闲(0代表闲，1代表庄)
     */
    private byte who;
    /**
     * 好像是庄闲所有的牌，还需要具体分析，参考e.prototype.getPokers
     */
    private byte[] bcards;
    private byte[] pcards;


    @Override
    public int getCmd() {
        return 380930;
    }

    @Override
    public Decode decode(ByteBuffer byteBuffer) {
        this.gmcode = DataUtil.getString(byteBuffer, 14);
        this.vid = DataUtil.getString(byteBuffer, 4);
        this.card = byteBuffer.get();
        this.index = byteBuffer.get();
        this.show = byteBuffer.get();
        this.who = byteBuffer.get();
        this.bcards = byteBuffer.get(new byte[3]).array();
        this.pcards = byteBuffer.get(new byte[3]).array();
        return this;
    }

    @Override
    public String toString() {
        return "Decode380930{" +
                "gmcode='" + gmcode + '\'' +
                ", vid='" + vid + '\'' +
                ", card=" + card +
                ", index=" + index +
                ", show=" + show +
                ", who=" + who +
                ", bcards=" + Arrays.toString(bcards) +
                ", pcards=" + Arrays.toString(pcards) +
                '}';
    }
}
