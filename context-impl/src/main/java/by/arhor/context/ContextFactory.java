package by.arhor.context;

import by.arhor.context.annotation.Bean;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ContextFactory {

    private ContextFactory() {
        throw new UnsupportedOperationException();
    }

    public static <T> Context getContext(Class<T> configClass) {

        T config;
        Map<Class, Object> beans = new HashMap<>();

        try {

            config = configClass.newInstance();

            for (Method method : configClass.getDeclaredMethods()) {
                boolean isBeanProducer = false;

                for (Annotation annotation : method.getDeclaredAnnotations()) {
                    if (annotation.annotationType().equals(Bean.class)) {
                        isBeanProducer = true;
                    }
                }

                if (isBeanProducer) {
                    Object bean = method.invoke(config);
                    beans.put(bean.getClass(), bean);
                }
            }



        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        ContextImpl ctx = new ContextImpl();

        ctx.init();
        ctx.setBeans(beans);

        return ctx;

    }

}
