package org.ag.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

/**
 * @author johoka
 */
public class XmlUtil {
    /**
     * 将XML转为指定的POJO对象
     * @param clazz
     * @param xmlStr
     * @return
     */
    public static Object xmlStrToObject(Class<?> clazz,String xmlStr) {
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            //xml转为对象的接口
            Unmarshaller unmarshaller=context.createUnmarshaller();
            Reader reader=new StringReader(xmlStr);
            Object xmlObject=unmarshaller.unmarshal(reader);
            reader.close();
            return xmlObject;
        } catch (Exception e) {
            throw new RuntimeException("xml to object exception",e);
        }
    }
}
