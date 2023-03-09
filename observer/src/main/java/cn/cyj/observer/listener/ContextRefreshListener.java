package cn.cyj.observer.listener;

import cn.cyj.observer.event.ContextRefreshEvent;

public class ContextRefreshListener implements ApplicationListener<ContextRefreshEvent> {
    
    public void onApplicationEvent(ContextRefreshEvent event) {
        System.out.println(">>ContextRefreshListener监听到ContextRefreshEvent事件");
    }
}
