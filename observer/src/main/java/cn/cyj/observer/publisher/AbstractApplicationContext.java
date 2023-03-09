package cn.cyj.observer.publisher;

import cn.cyj.observer.event.ApplicationEvent;
import cn.cyj.observer.listener.ContextCloseListener;
import cn.cyj.observer.listener.ContextRefreshListener;
import cn.cyj.observer.manager.SimpleApplicationEventMulticaster;

public class AbstractApplicationContext {

    private SimpleApplicationEventMulticaster applicationEventMulticaster = null;

    public void refresh() {
        initApplicationEventMulticaster();
        registerListeners();
    }

    protected void initApplicationEventMulticaster() {
        this.applicationEventMulticaster = new SimpleApplicationEventMulticaster();
    }

    protected void registerListeners() {
        this.applicationEventMulticaster.addApplicationListener(new ContextRefreshListener());
        this.applicationEventMulticaster.addApplicationListener(new ContextCloseListener());
    }

    public void publishEvent(ApplicationEvent event) {
        this.applicationEventMulticaster.multicastEvent(event);
    }
}
