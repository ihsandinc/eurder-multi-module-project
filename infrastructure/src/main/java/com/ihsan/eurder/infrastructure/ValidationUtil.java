package com.ihsan.eurder.infrastructure;

public class ValidationUtil {
    public static boolean isNullObject(Object object) {
        return object == null;
    }

    public static void throwExceptionIfNull(Object object, String objectName) {
        if (isNullObject(object)) {
            throw new IllegalArgumentException(objectName + " cannot be null.");
        }
    }

    public static boolean isValidUUIDLength(String uuid) {
        return uuid.length() == 36;
    }
}
