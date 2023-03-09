package cn.cyj.observer;

import cn.cyj.observer.event.ContextCloseEvent;
import cn.cyj.observer.event.ContextRefreshEvent;
import cn.cyj.observer.publisher.AbstractApplicationContext;
import org.junit.Test;

public class ApiTest {

    @Test
    public void testObserver() {
        AbstractApplicationContext applicationContext = new AbstractApplicationContext();
        applicationContext.refresh();

        System.out.println(">>ApplicationContext发送ContextRefreshEvent事件");
        applicationContext.publishEvent(new ContextRefreshEvent());
        System.out.println(">>ApplicationContext发送ContextCloseEvent事件");
        applicationContext.publishEvent(new ContextCloseEvent());
    }
}
