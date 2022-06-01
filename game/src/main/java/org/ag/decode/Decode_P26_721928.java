package org.ag.decode;

import lombok.Data;
import org.ag.domain.Head;
import org.ag.util.DataUtil;

import java.nio.ByteBuffer;

/**
 * 指定房间的服务器信息，对应P26
 * @author johoka
 */
@Data
public class Decode_P26_721928 implements Decode{
    private String vid;
    private int code;
    private String gameSvrId;
    private String gameSvrIp;

    @Override
    public int getCmd() {
        return 721928;
    }

    /**
     * 还未测试
     * @param byteBuffer
     * @return
     */
    @Override
    public Decode decode(ByteBuffer byteBuffer) {
        this.vid = DataUtil.getString(byteBuffer,4);
        this.code = byteBuffer.getInt();
        this.gameSvrId = DataUtil.getString(byteBuffer,4);
        this.gameSvrIp = DataUtil.getString(byteBuffer,21);

        return this;
    }

}
