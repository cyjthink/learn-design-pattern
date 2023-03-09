package cn.cyj.observer.listener;

import cn.cyj.observer.event.ApplicationEvent;

public interface ApplicationListener<E extends ApplicationEvent> {

    void onApplicationEvent(E event);
}
