package org.example.circularreferences;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AServiceImpl implements AService {

    @Autowired
    private BServiceImpl bService;


    @Override
    public void test() {
        System.out.println("AServiceImpl中的B："+bService);
    }
}
