package cn.cyj.observer.manager;

import cn.cyj.observer.event.ApplicationEvent;
import cn.cyj.observer.listener.ApplicationListener;

public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

    public void multicastEvent(ApplicationEvent event) {
        for (ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
