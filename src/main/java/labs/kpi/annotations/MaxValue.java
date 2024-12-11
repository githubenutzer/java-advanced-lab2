package labs.kpi.annotations;

import java.lang.annotation.*;

/**
 * Annotation to specify the maximum allowed value for numeric fields.
 *
 * @author Oleksii Kyrychenko
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MaxValue {
    int value();
}

