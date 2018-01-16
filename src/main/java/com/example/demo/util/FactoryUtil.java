package com.example.demo.util;

import com.example.demo.annotation.SupportCodes;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * ========================
 *
 * @author 小龙虾
 * Created with IntelliJ IDEA.
 * Date：2018/1/11
 * Time：16:47
 * ========================
 */
@Component
public class FactoryUtil implements ApplicationContextAware {

    private static Map<Class<?>, Map<String, Object>> serviceImplFactoryMap = new HashMap<Class<?>, Map<String, Object>>();
    private static AbstractApplicationContext appContext;

    /**
     * 获取ServiceImpl
     * @param interfaceClass
     * @param sopportCode
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T getServiceImpl(Class<T> interfaceClass, String sopportCode) {
        if (null == serviceImplFactoryMap.get(interfaceClass)) {
            init(interfaceClass);
            if (null == serviceImplFactoryMap) {
                return null;
            }
        }
        if (null == serviceImplFactoryMap.get(interfaceClass)) {
            return null;
        }
        return (T) serviceImplFactoryMap.get(interfaceClass).get(sopportCode);
    }

    protected static <T extends Object> void init(Class<T> interfaceClass) {
        System.out.println("begin to init " + interfaceClass);
        synchronized (FactoryUtil.class) {
            try {
                if (null != serviceImplFactoryMap.get(interfaceClass)) {
                    return;
                }
                Map<String, Object> serviceMap = new HashMap<String, Object>();
                Map<String, T> beans = appContext.getBeansOfType(interfaceClass);
                Set<Entry<String, T>> entrySet = beans.entrySet();
                Iterator<Entry<String, T>> iterator = entrySet.iterator();
                while (iterator.hasNext()) {
                    Object interfaceServiceImpl = iterator.next().getValue();
                    SupportCodes annotationValue = interfaceServiceImpl.getClass().getAnnotation(SupportCodes.class);
                    if (null != annotationValue) {
                        for (String falg : annotationValue.value()) {
                            serviceMap.put(falg, interfaceServiceImpl);
                            System.out.println(falg + "=>" + interfaceServiceImpl.getClass());
                        }
                    }
                }
                serviceImplFactoryMap.put(interfaceClass, serviceMap);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(interfaceClass + "inited");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        appContext = (AbstractApplicationContext) applicationContext;
        System.out.println("哈哈哈");
    }
}
