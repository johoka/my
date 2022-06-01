package org.ag.encode;

import com.sun.xml.internal.rngom.parse.host.Base;
import lombok.Data;
import org.ag.util.DataUtil;

import java.nio.ByteBuffer;

/**
 * 登入牌桌
 * @author johoka
 */
@Data
public class Encode_P3_263681 implements Encode{
    private String name;
    private byte[] md5;
    private byte[] type;
    private byte language;

    @Override
    public void encode(ByteBuffer byteBuffer) throws Exception {
        DataUtil.putString(byteBuffer,this.name,30);


//        return Base.putString(t, this.name, 30), t.put(this.md5), t.put(this.type), t.put(this.language), Log.d("--send plaza P3"), true;

    }
}
