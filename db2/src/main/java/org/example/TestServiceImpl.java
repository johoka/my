package org.example;

import org.springframework.stereotype.Service;

//@Service
public class TestServiceImpl implements TestService{
    @Override
    public void test1() {
        System.out.println("test1");
    }

    @Override
    public void test2(String id) {
        System.out.println("test1Id");
    }
}
