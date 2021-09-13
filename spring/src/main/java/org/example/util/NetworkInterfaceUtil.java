package org.example.util;

import java.net.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class NetworkInterfaceUtil {

    private static List<NetworkInterface> getInterfaces() throws SocketException {
        return Collections.list(NetworkInterface.getNetworkInterfaces());
    }

    private static List<NetworkInterface> getNonLoopBackInterfaces() throws SocketException {
        return getInterfaces();
//        return getInterfaces().org.example.stream()
//                .filter(i -> {
//                    try {
//                        return !i.isLoopback();
//                    } catch (SocketException e) {
//                        e.printStackTrace();
//                    }
//                    return false;
//                })
//                .collect(toList());
    }

    public static List<String> getIp4Addresses() throws SocketException {
        final List<NetworkInterface> is = getNonLoopBackInterfaces();
        return is.stream().flatMap(i -> {
            final Enumeration<InetAddress> addresses = i.getInetAddresses();
            final Stream.Builder<String> builder = Stream.builder();
            while (addresses.hasMoreElements()) {
                final InetAddress ip = addresses.nextElement();
//                if (!ip.isLoopbackAddress()) {
//                    if (ip.getHostAddress().equalsIgnoreCase("127.0.0.1")) {
//                        continue;
//                    }
//                    if (ip instanceof Inet6Address) {
//                        continue;
//                    }
//                    if (ip instanceof Inet4Address) {
//                        builder.add(ip.getHostAddress());
//                    }
//                }
                builder.add(ip.getHostAddress());
            }
            return builder.build();
        }).collect(toList());
    }

    public static void main(String[] args) throws SocketException, UnknownHostException {
//        List<String> ip4Addresses = getIp4Addresses();
//        System.out.println(ip4Addresses);


//        List<String> list = Arrays.asList("beijing changcheng", "beijing gugong", "beijing tiantan", "gugong tiananmen");
//        //map只能将分割结果转成一个List,所以输出为list对象
//        list.org.example.stream().map(item -> Arrays.org.example.stream(item.split(" ")
//        )).forEach(System.out::println);
//        //map需要循环两次
//        list.org.example.stream().map(item -> Arrays.org.example.stream(item.split(" "))).forEach(n -> {
//            n.forEach(System.out::println);
//        });
//        //flatmap将二维转为一维
//        list.org.example.stream().flatMap(item -> Arrays.org.example.stream(item.split(" ")
//        )).forEach(System.out::println);

        InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
        System.out.println(inetAddress);
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
        InetAddress loopbackAddress = InetAddress.getLoopbackAddress();
        System.out.println(loopbackAddress);
    }
}
