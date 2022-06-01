package org.ag.encode;

import lombok.Data;
import org.ag.constant.ProtoTypes;
import org.ag.domain.Head;
import org.ag.util.DataUtil;

import java.nio.ByteBuffer;

/**
 * 登入具体游戏
 * @author johoka
 */
@Data
public class Encode_G1_69633 implements Encode{

    private String name;
    private int[] token;
    private byte type = ProtoTypes.DEVICE_TYPE;


    @Override
    public void encode(ByteBuffer byteBuffer) throws Exception {
        Head head = new Head();
        head.setCid(69633);
        head.setCSize(63);
        //todo 这个应该是变量
        head.setCSeq(10000021);
        head.setSession((short) 0);
        head.setVer((short) 2);
        head.encode(byteBuffer);

        DataUtil.putString(byteBuffer,this.name,30);
//        byteBuffer.put(token);
        for (int i : token) {
            byteBuffer.put((byte) i);
        }
        byteBuffer.put(type);
//        function e() {
//            var r = t.call(this, e.PROTOID) || this;
//            return r.type = ProtoTypes.DEVICE_TYPE, r;
//        }
//        return __extends(e, t), e.prototype.setNameAndPwd = function (t, e) {
//            this.name = t, "string" == typeof e ? this.token = MD5Util.toMd5_16b(t + "keno8" + e) : this.token = e;
//        }, e.prototype.encode = function (t) {
//            return Base.putString(t, this.name, 30), t.put(this.token), t.put(this.type), Log.d("--send game login G1"), true;
//        }, e;
    }
}
