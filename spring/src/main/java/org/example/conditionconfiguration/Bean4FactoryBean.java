package org.example.conditionconfiguration;

import org.springframework.beans.factory.*;
import org.springframework.stereotype.Component;

@Component
public class Bean4FactoryBean implements FactoryBean<Bean4> {

    @Override
    public Bean4 getObject() throws Exception {
        return new Bean4();
    }

    @Override
    public Class<?> getObjectType() {
        return Bean4.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
