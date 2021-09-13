package org.example.placeholder;


import org.example.circularreferences.AService;
import org.example.circularreferences.BService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class PlaceholderBean {

    public void setProperty1(String property1) {
        this.property1 = property1;
    }

    @Value("classpath:test.properties")
    private Resource resource;
    @Value("${test}")
    private String property1;

    @Autowired
    private AService aService;
    @Autowired
    private BService bService;

    public String getValue(){
        return property1;
    }
}
