package cn.cyj.observer.listener;

import cn.cyj.observer.event.ContextCloseEvent;

public class ContextCloseListener implements ApplicationListener<ContextCloseEvent> {

    public void onApplicationEvent(ContextCloseEvent event) {
        System.out.println(">>ContextCloseListener监听到ContextCloseEvent事件");
    }
}
