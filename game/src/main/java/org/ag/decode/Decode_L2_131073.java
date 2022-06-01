package org.ag.decode;

import lombok.Getter;
import lombok.Setter;
import org.ag.util.DataUtil;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * 解密第一次登入，获取返回的信息（主要是获取token，为第二次登入做准备）
 * @author johoka
 */
@Getter
@Setter
public class Decode_L2_131073 implements Decode{
    private int code;
    private int[] token;
    private long datetime;
    private int userFlag;
    private String plazaServer;
    private String serverId;
    private String uid;
    private int freemode;

    @Override
    public int getCmd() {
        return 0;
    }

    @Override
    public Decode decode(ByteBuffer byteBuffer) {
        this.code = byteBuffer.getInt();
        int[] tokenBytes = new int[16];
        for (int i = 0; i < tokenBytes.length; i++) {
            tokenBytes[i] = (byteBuffer.get() & 0xFF);
        }
        //getU(16)
        this.token = tokenBytes;
        this.datetime = byteBuffer.getLong();
        this.userFlag = byteBuffer.getInt();
        this.plazaServer = DataUtil.getString(byteBuffer,32);
        this.serverId = DataUtil.getString(byteBuffer,4);
        this.uid = DataUtil.getString(byteBuffer,16);
        this.freemode = byteBuffer.getInt();

        return this;
    }

    @Override
    public String toString() {
        return "DecodeLogin1{" +
                "code=" + code +
                ", token=" + Arrays.toString(token) +
                ", datetime=" + datetime +
                ", userFlag=" + userFlag +
                ", plazaServer='" + plazaServer + '\'' +
                ", serverId='" + serverId + '\'' +
                ", uid='" + uid + '\'' +
                ", freemode=" + freemode +
                '}';
    }
}
