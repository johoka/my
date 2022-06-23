package org.ag.domain;

import lombok.Getter;
import lombok.Setter;

import java.nio.ByteBuffer;

/**
 * @author johoka
 */
@Getter
@Setter
public class Head {
    private Integer cid;
    private Integer cSize;
    private Integer cSeq;
    private Short session;
    private Short ver;

    //头部长度，不用发送给服务器，仅做记录用
    private Integer headLength = 16;

    public Head decode(ByteBuffer byteBuffer){
        this.cid = byteBuffer.getInt();
        this.cSize = byteBuffer.getInt();
        this.cSeq = byteBuffer.getInt();
        this.session = byteBuffer.getShort();
        this.ver = byteBuffer.getShort();

        return this;
    }

    public Head encode(ByteBuffer byteBuffer){
        byteBuffer.putInt(this.cid);
        byteBuffer.putInt(this.cSize);
        byteBuffer.putInt(this.cSeq);
        byteBuffer.putShort(this.session);
        byteBuffer.putShort(this.ver);
        return this;
    }

    @Override
    public String toString() {
        return "DecodeHead{" +
                "cid=" + cid +
                ", cSize=" + cSize +
                ", cSeq=" + cSeq +
                ", session=" + session +
                ", ver=" + ver +
                '}';
    }
}
