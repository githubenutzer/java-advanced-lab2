package labs.kpi.annotations;

import java.lang.annotation.*;

/**
 * Annotation to specify the allowed length range for string fields.
 *
 * @author Oleksii Kyrychenko
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface StringLength {
    int min() default 0;
    int max() default Integer.MAX_VALUE;
}