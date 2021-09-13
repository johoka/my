package org.example.stream;

import org.springframework.util.StreamUtils;

import java.io.*;

public class BigData {
    public static void main(String[] args) throws IOException {
        File inFile = new File("/Users/johoka/IdeaProjects/mystudy/spring/src/main/resources/bigDataTest_in.text");
        File outFile = new File("/Users/johoka/IdeaProjects/mystudy/spring/src/main/resources/bigDataTest_out.text");

//        需要好好研究下
//        FileDescriptor.in;
//        FileDescriptor.out;
//        FileDescriptor.err;
        FileInputStream fileInputStream = new FileInputStream(inFile);
//        byte[] buf = new byte[1024];
//        int length = 0;
//        List<String> list = new ArrayList<>();
//        //循环读取文件内容，输入流中将最多buf.length个字节的数据读入一个buf数组中,返回类型是读取到的字节数。
//        //当文件读取到结尾时返回 -1,循环结束。
//        while((length = fileInputStream.read(buf)) != -1){
////            String s = new String(buf, 0, length);
////            list.add(s);
//            System.out.print(new String(buf,0,length));
//        }
        FileOutputStream fileOutputStream = new FileOutputStream(outFile);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);

        int copy = StreamUtils.copy(fileInputStream, fileOutputStream);
        System.out.println(copy);
        //最后记得，关闭流
        fileInputStream.close();
        fileOutputStream.close();
    }
}
