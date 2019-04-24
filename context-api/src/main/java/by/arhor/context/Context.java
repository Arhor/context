package by.arhor.context;

public interface Context {

    void init();

    void destroy();

    <T> T getBean(Class<T> clazz);

}
