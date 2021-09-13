package org.example.instrospector;

public class BeanInfoTest {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("peida");
        try {
            BeanInfoUtil.getProperty(userInfo, "userName");
            BeanInfoUtil.setProperty(userInfo, "userName");
            BeanInfoUtil.getProperty(userInfo, "userName");
            BeanInfoUtil.setPropertyByIntrospector(userInfo, "userName");
            BeanInfoUtil.getPropertyByIntrospector(userInfo, "userName");
            BeanInfoUtil.setProperty(userInfo, "age");  // IllegalArgumentException
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
