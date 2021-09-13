package org.example.circularreferences;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class BServiceImpl implements BService, InitializingBean {

    @Autowired
    private AServiceImpl aService;

    @Override
    public void test() {
        System.out.println(aService.getClass());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("ok");
    }
}
