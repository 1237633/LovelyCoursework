package sky.pro.java.course2.homework17;

import org.apache.commons.lang3.StringUtils;
import sky.pro.java.course2.homework17.exceptions.BadRequestException;

public class EmployeeKey {
    private static final String FORBIDDEN = "1234567890!@#$%^&*()=";
    public static String inputToKey(String firstName, String lastName) {
        if (StringUtils.containsAny(firstName, FORBIDDEN) || StringUtils.containsAny(lastName, FORBIDDEN)) {
            throw new BadRequestException("Forbidden char!");
        }
        String result = firstName.trim() + lastName.trim();
        return result.toLowerCase();
    }
}
