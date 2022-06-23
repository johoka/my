package org.ag.test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

public class Convert {

    public static void main(String[] args) throws Exception {
        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<c c1=\"0\">\n" +
                "  <d d1=\"101280101\" d2=\"广州\" d3=\"guangzhou\" d4=\"广东\">我是d</d>\n" +
                "  <d d1=\"101280102\" d2=\"番禺\" d3=\"panyu\" d4=\"广东\">我是d</d>\n" +
                "  <d d1=\"101280103\" d2=\"从化\" d3=\"conghua\" d4=\"广东\">我是d</d>\n" +
                "</c>";

        Object o = xmlStrToObject(CityList.class, str);
        System.out.println(o);
    }

    /**
     * 将XML转为指定的POJO对象
     * @param clazz
     * @param xmlStr
     * @return
     */
    public static Object xmlStrToObject(Class<?> clazz,String xmlStr) throws Exception {
        JAXBContext context=JAXBContext.newInstance(clazz);
        //xml转为对象的接口
        Unmarshaller unmarshaller=context.createUnmarshaller();
        Reader reader=new StringReader(xmlStr);
        Object xmlObject=unmarshaller.unmarshal(reader);
        reader.close();
        return xmlObject;
    }

}
