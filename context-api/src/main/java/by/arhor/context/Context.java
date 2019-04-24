package by.arhor.context;

import java.io.Closeable;

public interface Context extends Closeable {

    void init();

    void destroy();

    <T> T getBean(Class<T> clazz);

    @Override
    void close();

}
