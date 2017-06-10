package example.spring.profile.config;

import example.spring.profile.domain.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * User : Dongle (Dongkyun)
 * Date : 5/13/17
 */
@Configuration
@Profile("develop")
public class AppConfigForDevelop {
    /**
     * This bean will be created when profile is develop
     *
     * @return
     */
    @Bean
    public Employee getPresident() {
        return new Employee("develop-president", "develop-CEO", 1000);
    }
}
