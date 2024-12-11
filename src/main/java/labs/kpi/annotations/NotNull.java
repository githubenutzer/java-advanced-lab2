package labs.kpi.annotations;

import java.lang.annotation.*;

/**
 * Annotation to specify that a field cannot be null.
 *
 * @author Oleksii Kyrychenko
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface NotNull {
}

