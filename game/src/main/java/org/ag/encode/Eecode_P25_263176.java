package org.ag.encode;

import lombok.Data;
import org.ag.constant.ProtoTypes;
import org.ag.domain.Head;
import org.ag.util.DataUtil;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * 点击进入房间
 * @author johoka
 */
@Data
public class Eecode_P25_263176 implements Encode{

    /**
     * 房间号
     */
    private String vid;
    private int code = ProtoTypes.CC_VERSION << 16;


    public Eecode_P25_263176(String vid) {
        this.vid = vid;
    }

    @Override
    public void encode(ByteBuffer byteBuffer) throws Exception {
        Head head = new Head();
        head.setCid(263176);
        head.setCSize(24);
        //todo 这个应该是变量
        head.setCSeq(10000006);
        head.setSession((short) 0);
        head.setVer((short) 2);

        head.encode(byteBuffer);

        DataUtil.putString(byteBuffer,this.vid,4);
        byteBuffer.putInt(this.code);
    }

    public static void main(String[] args) throws Exception {
//        cId: 263176
//        cSeq: 10000181
//        cSize: 0
//        session: 0
//        ver: 2
        Eecode_P25_263176 eecode_p25_263176 = new Eecode_P25_263176("B002");
        ByteBuffer byteBuffer = ByteBuffer.allocate(24);
        eecode_p25_263176.encode(byteBuffer);
        System.out.println(Arrays.toString(byteBuffer.array()));
        System.out.println(bytesToHexString(byteBuffer.array()));

    }

    public static String bytesToHexString(byte[] src){
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
}

//            0004 0408 0000 0000 0098 9694 0000 0002 4230 3035 0004 0408
//00000000: 0004 0408 0000 0018 0098 9689 0000 0002  ................
//00000001: 4230 3035 0068 0000                      B005.h..
//            0004 0408 0000 0018 0098 9735 0000 0002 4230 3032 0068 0000
//          0004 0408 0000 0018 0098 9735 0000 0002 4430 3733 0068 0000
//00000000: 0004 0408 0000 0018 0098 9735 0000 0002  ...........5....
//00000001: 4430 3733 0068 0000                      D073.h..