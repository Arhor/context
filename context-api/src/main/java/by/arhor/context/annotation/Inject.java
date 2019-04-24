package by.arhor.context.annotation;

import java.lang.annotation.*;

/**
 * Indicates that marked element dependencies should be injected.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.CONSTRUCTOR)
public @interface Inject {
}
