package labs.kpi.annotations;

import java.lang.annotation.*;

/**
 * Annotation to specify the minimum allowed value for numeric fields.
 *
 * @author Oleksii Kyrychenko
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MinValue {
    int value();
}