package org.example.di;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class BeanFactory {
    private final Set<Class<?>> preInstantiatedClazz;
    private Map<Class<?>, Object> beans = new HashMap<>();
    public BeanFactory(Set<Class<?>> preInstantiatedClazz) {
        this.preInstantiatedClazz = preInstantiatedClazz;
        initialize();
    }

    private void initialize() {
        for (Class<?> clazz : preInstantiatedClazz) {
            Object instance = createInstance(clazz);
            beans.put(clazz, instance);
        }
    }

    private Object createInstance(Class<?> clazz) {
        // constructor
        Constructor<?> constructor = findConstructor(clazz);

        // parameter
        List<Object> parameters = new ArrayList<>();
        for (Class<?> typeClass : constructor.getParameterTypes()) {
            parameters.add(getParameterByClass(typeClass));
        }

        // create instance
        try {
            return constructor.newInstance(parameters.toArray());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }

    private Object getParameterByClass(Class<?> typeClass) {
        Object instanceBeans = getBean(typeClass);
        if (Objects.nonNull(instanceBeans)) {
            return instanceBeans;
        }

        return createInstance(typeClass);
    }

    private Constructor<?> findConstructor(Class<?> clazz) {
        return getConstructor(clazz);
    }
    private Constructor<?> getConstructor(Class<?> clazz) {
        Constructor<?> constructor = BeanFactoryUtils.getInjectedConstructor(clazz);

        if (Objects.nonNull(constructor)) {
            return constructor;
        }

        return clazz.getConstructors()[0];
    }

    public <T> T getBean(Class<?> requiredType) {
        return (T) beans.get(requiredType);
    }
}
