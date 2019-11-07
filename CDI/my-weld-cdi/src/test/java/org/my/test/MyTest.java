package org.my.test;

import com.mycompany.my.weld.cdi.Developer;
import org.junit.Test;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

import static org.junit.Assert.assertEquals;

public class MyTest {

    @Test
    public void test(){
        SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        SeContainer container = initializer.initialize();
        Instance<Developer> lazyDeveloper = container.select(Developer.class);
        Developer developer = lazyDeveloper.get();
        String msg = developer.develop();
        assertEquals("Coffee develop", msg);

    }
}
