package labs.kpi.validators;

import labs.kpi.annotations.*;
import java.lang.reflect.Field;

/**
 * Validator class for performing reflection-based field validation.
 *
 * @author Oleksii Kyrychenko
 */
public class FieldValidator {

    /**
     * Validates the fields of an object based on annotations.
     *
     * @param obj The object to validate.
     * @throws IllegalAccessException If field access is illegal.
     */
    public static void validate(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);

            Object value = getFieldValue(field, obj);

            validateNotNull(field, value);
            validateStringLength(field, value);
            validateMinValue(field, value);
            validateMaxValue(field, value);
        }
    }

    private static Object getFieldValue(Field field, Object obj) throws IllegalAccessException {
        return field.get(obj);
    }

    private static void validateNotNull(Field field, Object value) {
        if (field.isAnnotationPresent(NotNull.class) && value == null) {
            throw new IllegalArgumentException("Field '" + field.getName() + "' cannot be null.");
        }
    }

    private static void validateStringLength(Field field, Object value) {
        if (field.isAnnotationPresent(StringLength.class) && value instanceof String strValue) {
            StringLength annotation = field.getAnnotation(StringLength.class);
            if (strValue.length() < annotation.min() || strValue.length() > annotation.max()) {
                throw new IllegalArgumentException("Field '" + field.getName() + "' must be between " +
                        annotation.min() + " and " + annotation.max() + " characters.");
            }
        } else if (field.isAnnotationPresent(StringLength.class)) {
            throw new IllegalArgumentException("Field '" + field.getName() + "' has @StringLength but is not a String.");
        }
    }

    private static void validateMinValue(Field field, Object value) {
        if (field.isAnnotationPresent(MinValue.class) && value instanceof Integer intValue) {
            MinValue annotation = field.getAnnotation(MinValue.class);
            if (intValue < annotation.value()) {
                throw new IllegalArgumentException("Field '" + field.getName() + "' cannot be less than " + annotation.value());
            }
        } else if (field.isAnnotationPresent(MinValue.class)) {
            throw new IllegalArgumentException("Field '" + field.getName() + "' has @MinValue but is not an Integer.");
        }
    }

    private static void validateMaxValue(Field field, Object value) {
        if (field.isAnnotationPresent(MaxValue.class) && value instanceof Integer intValue) {
            MaxValue annotation = field.getAnnotation(MaxValue.class);
            if (intValue > annotation.value()) {
                throw new IllegalArgumentException("Field '" + field.getName() + "' cannot be greater than " + annotation.value());
            }
        } else if (field.isAnnotationPresent(MaxValue.class)) {
            throw new IllegalArgumentException("Field '" + field.getName() + "' has @MaxValue but is not an Integer.");
        }
    }
}