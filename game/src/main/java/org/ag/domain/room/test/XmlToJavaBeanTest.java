package org.ag.domain.room.test;

import org.ag.domain.room.RoomConfig;
import org.ag.util.XmlUtil;

import javax.annotation.Resource;
import java.io.*;

/**
 * @author johoka
 */
public class XmlToJavaBeanTest {
    public static void main(String[] args) throws Exception {
        //读取xml文件
        File file = new File("/Users/johoka/IdeaProjects/my/game/src/main/java/org/ag/data/房间信息.xml");

        BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8"));
        StringBuilder buffer=new StringBuilder();
        String line="";
        while((line=reader.readLine())!=null){
            buffer.append(line);
        }
        reader.close();

        System.out.println(buffer.toString());
        Object obj = XmlUtil.xmlStrToObject(RoomConfig.class, buffer.toString());
        System.out.println(obj.toString());

    }
}
