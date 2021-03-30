package utils;
import java.util.UUID;

public class ApplicationUtils {

    public static String generateNewUUID() {
        return UUID.randomUUID().toString();
    }
}
