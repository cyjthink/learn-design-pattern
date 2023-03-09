package cn.cyj.observer.manager;

import cn.cyj.observer.event.ApplicationEvent;
import cn.cyj.observer.listener.ApplicationListener;
import cn.cyj.observer.util.ClassUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

public abstract class AbstractApplicationEventMulticaster implements ApplicationEventMulticaster {

    private Set<ApplicationListener> applicationListeners = new LinkedHashSet<ApplicationListener>();

    public void addApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.add(listener);
    }

    public void removeApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.remove(listener);
    }

    public Collection<ApplicationListener> getApplicationListeners(ApplicationEvent event) {
        List<ApplicationListener> allListeners = new ArrayList<>();
        for (ApplicationListener listener : applicationListeners) {
            if (supportsEvent(listener, event)) {
                allListeners.add(listener);
            }
        }
        return allListeners;
    }

    protected boolean supportsEvent(ApplicationListener<?> listener, ApplicationEvent event) {
        Class<? extends ApplicationListener> listenerClass = listener.getClass();

        // 按照 CglibSubclassingInstantiationStrategy、SimpleInstantiationStrategy 不同的实例化类型，需要判断后获取目标 class
        Class<?> targetClass = ClassUtils.isCglibProxyClass(listenerClass) ? listenerClass.getSuperclass() : listenerClass;
        Type genericInterface = targetClass.getGenericInterfaces()[0];

        Type actualTypeArgument = ((ParameterizedType) genericInterface).getActualTypeArguments()[0];
        String className = actualTypeArgument.getTypeName();
        Class<?> eventClassName;
        try {
            eventClassName = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("wrong event class name: " + className);
        }
        // 判定此 eventClassName 对象所表示的类或接口与指定的 event.getClass() 参数所表示的类或接口是否相同，或是否是其超类或超接口。
        // isAssignableFrom是用来判断子类和父类的关系的，或者接口的实现类和接口的关系的，默认所有的类的终极父类都是Object。如果A.isAssignableFrom(B)结果是true，证明B可以转换成为A,也就是A可以由B转换而来。
        return eventClassName.isAssignableFrom(event.getClass());
    }
}
