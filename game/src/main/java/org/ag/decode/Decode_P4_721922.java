package org.ag.decode;

import org.ag.domain.room.RoomConfig;
import org.ag.util.GZIPUtils;
import org.ag.util.XmlUtil;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * 房间信息集合，对应P4
 * @author johoka
 */
public class Decode_P4_721922 implements Decode{
    @Override
    public int getCmd() {
        return 721922;
    }

    @Override
    public Decode decode(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        byte[] dest = new byte[remaining];
        byteBuffer.get(dest);
        System.out.println("剩余长度：" + dest.length);
        byte[] newBytes = GZIPUtils.inflater(dest);
        assert newBytes != null;
        System.out.println("解压后长度：" + newBytes.length);
        String xmlStr = new String(newBytes, StandardCharsets.UTF_8);
        System.out.println(xmlStr);
        RoomConfig roomConfig = (RoomConfig) XmlUtil.xmlStrToObject(RoomConfig.class, xmlStr);
//        System.out.println(roomConfig);

        return this;
    }
}
