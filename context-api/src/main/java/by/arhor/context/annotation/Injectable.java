package by.arhor.context.annotation;

import java.lang.annotation.*;

/**
 * Indicates that marked class represents injectable bean.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Injectable {

    Scopes scope() default Scopes.SINGLETON;

}
