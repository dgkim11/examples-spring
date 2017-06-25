package example.spring.profile.config;

import example.spring.profile.config.properties.PropertiesConfig;
import example.spring.profile.config.web.WebApplicationConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * User : Dongle (Dongkyun)
 * Date : 5/13/17
 */
@Configuration
@Import({PropertiesConfig.class, WebApplicationConfig.class})
@ComponentScan(basePackages = { "example.spring.profile.beans"} )
public class AppConfig {
}
