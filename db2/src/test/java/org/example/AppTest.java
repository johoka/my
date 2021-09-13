package org.example;

import static org.junit.Assert.assertTrue;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.IntStream;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class AppTest {

//    @Autowired
//    private DruidDataSource druidDataSource;
//
//    @Test
//    public void test() throws Exception {
//        System.out.println(druidDataSource);
////        DruidPooledConnection connection = druidDataSource.getConnection();
//
//        new Thread(() -> {
//            try {
//                final DruidPooledConnection connection = druidDataSource.getConnection();
//                connection.setAutoCommit(Boolean.FALSE);
//                final Statement stmt = connection.createStatement();
//
////            ResultSet rs = stmt.executeQuery("select 1 from dual") ;
//                stmt.executeUpdate("update test set val1 = '1' where id = '1'");
//                stmt.executeUpdate("update test set val1 = '1' where id = '2'");
//                System.out.println("ok");
//            } catch (Exception throwables) {
//                throwables.printStackTrace();
//            }
//        }).start();
//
//        new Thread(() -> {
//            try {
//                final DruidPooledConnection connection = druidDataSource.getConnection();
//                connection.setAutoCommit(Boolean.FALSE);
//                final Statement stmt = connection.createStatement();
////            ResultSet rs = stmt.executeQuery("select 1 from dual") ;
//                stmt.executeUpdate("update test set val1 = '2' where id = '2'");
//                stmt.executeUpdate("update test set val1 = '2' where id = '1'");
//                System.out.println("ok");
//            } catch (Exception throwables) {
//                throwables.printStackTrace();
//            }
//        }).start();
//
//
////        IntStream.range(1,2).parallel().forEach((i)->{
////            try {
//////                druidDataSource.getConnection();
////
////                Statement stmt = connection.createStatement() ;
//////        PreparedStatement pstmt = connection.prepareStatement("select 1 from dual") ;
////                ResultSet rs = stmt.executeQuery("select 1 from dual") ;
////                while(rs.next()){
////                    String pass = rs.getString(1) ; // 此方法比较高效
////                    System.out.println(pass);
////                }
////            } catch (SQLException throwables) {
////                throwables.printStackTrace();
////            }
////        });
////        while(true){
////            Statement stmt = connection.createStatement() ;
//////        PreparedStatement pstmt = connection.prepareStatement("select 1 from dual") ;
////            ResultSet rs = stmt.executeQuery("select 1 from dual") ;
////            while(rs.next()){
////                String pass = rs.getString(1) ; // 此方法比较高效
////                System.out.println(pass);
////            }
////        }
//
//        System.out.println(druidDataSource.getPoolingCount());
//        Thread.sleep(1000 * 60 * 60);
//    }

    @Autowired
    private TestService testService;

    @Test
    public void testProxy(){
        System.out.println(AopUtils.isAopProxy(testService));
        System.out.println(testService);
    }
}
