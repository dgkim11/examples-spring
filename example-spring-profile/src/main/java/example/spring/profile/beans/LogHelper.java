package example.spring.profile.beans;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * User : Dongle (Dongkyun)
 * Date : 6/25/17
 */
@Component
public class LogHelper {
    @Profile("develop")
    public String getMessage(String message) {
        return "[Develop]" + message;
    }
}
