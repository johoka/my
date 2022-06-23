package org.ag.encode;

import com.sun.xml.internal.rngom.parse.host.Base;
import lombok.Getter;
import lombok.Setter;
import org.ag.domain.Head;
import org.ag.util.DataUtil;

import java.nio.ByteBuffer;

/**
 * 进桌，G21
 * @author johoka
 */
@Getter
@Setter
public class Encode_G21_65648 implements Encode{

    /**
     * eg.B005
     */
    private String vid;
    /**
     * eg.A
     */
    private String oddtype = "A";


    @Override
    public void encode(ByteBuffer byteBuffer) throws Exception {
        Head head = new Head();
        head.setCid(65648);
        head.setCSize(24);
        //todo 这个应该是变量
        head.setCSeq(10000021);
        head.setSession((short) 0);
        head.setVer((short) 2);
        head.encode(byteBuffer);

        DataUtil.putString(byteBuffer,this.vid,4);
        DataUtil.putString(byteBuffer,this.oddtype,4);
    }
}
