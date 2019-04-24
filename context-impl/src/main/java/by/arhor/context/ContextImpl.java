package by.arhor.context;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"unchecked"})
public class ContextImpl implements Context {

    private Map<Class, Object> beans;

    ContextImpl() {}

    @Override
    public void init() {
        System.out.println("initializing context...");
        this.beans = new HashMap<>();
    }

    @Override
    public void destroy() {
        System.out.println("destroying context...");
        this.beans.clear();
    }

    @Override
    public <T> T getBean(Class<T> clazz) {
        T bean = (T) this.beans.get(clazz);

        if (bean == null) {
            throw new RuntimeException("couldn't find appropriate bean");
        }

        return bean;
    }

    @Override
    public void close() {
        this.destroy();
    }

    void setBeans(Map<Class, Object> beans) {
        this.beans.putAll(beans);
    }

}
