package cn.cyj.observer.manager;

import cn.cyj.observer.event.ApplicationEvent;
import cn.cyj.observer.listener.ApplicationListener;

public interface ApplicationEventMulticaster {

    void addApplicationListener(ApplicationListener<?> listener);

    void removeApplicationListener(ApplicationListener<?> listener);

    void multicastEvent(ApplicationEvent event);
}
