package example.spring.profile.config.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * configuration to read properties in a property xml file based on the current active profile.
 * PropertySource annotation can have multiple properties files.
 * Note that the order of the declared files is important. If the same key is defined in two or more files,
 * the value associated with the key in the last declared file will override any previous value(s).
 *
 * User : Dongle (Dongkyun)
 * Date : 6/17/17
 */
@Configuration
public class PropertiesConfig {
    @Autowired
    private Environment env;

    @Profile("develop")
    @PropertySource({ "classpath:profile-common.xml", "classpath:profile-develop.xml"})
    public static class DevProperties  {
        @Bean
        public static PropertySourcesPlaceholderConfigurer propertyConfig() {
            return new PropertySourcesPlaceholderConfigurer();
        }
    }
    @Profile("integration")
    @PropertySource({ "classpath:profile-common.xml", "classpath:profile-integration.xml"})
    public static class IntegrationProperties   {
        @Bean
        public static PropertySourcesPlaceholderConfigurer propertyConfig() {
            return new PropertySourcesPlaceholderConfigurer();
        }
    }
    @Profile("production")
    @PropertySource({ "classpath:profile-common.xml", "classpath:profile-production.xml"})
    public static class ProductionProperties   {
        @Bean
        public static PropertySourcesPlaceholderConfigurer propertyConfig() {
            return new PropertySourcesPlaceholderConfigurer();
        }
    }

    @Bean("proxyProperties")
    public PropertiesFactoryBean proxyPropertiesFactory()    {
        PropertiesFactoryBean factoryBean = new PropertiesFactoryBean();
        List<ClassPathResource> resources =
                Arrays.stream(env.getActiveProfiles())
                .map(profile -> new ClassPathResource("proxy/proxy-" + profile + ".xml"))
                .collect(Collectors.toList());
        factoryBean.setLocations(resources.toArray(new ClassPathResource[resources.size()]));

        return factoryBean;
    }
}
