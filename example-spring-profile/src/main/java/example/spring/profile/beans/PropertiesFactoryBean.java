package example.spring.profile.beans;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Properties;

/**
 * User : Dongle (Dongkyun)
 * Date : 6/17/17
 */
public class PropertiesFactoryBean implements FactoryBean<Properties> {
    @Autowired
    private ResourceLoader resourceLoader;

    private Properties properties;

    private String propertiesPath;


    public PropertiesFactoryBean(String filepath)   {
        propertiesPath = filepath;
    }

    @PostConstruct
    private Properties readPropertiesFromFile() throws IOException {
        properties = new Properties();
        Resource resource = resourceLoader.getResource(propertiesPath);
        properties.loadFromXML(resource.getInputStream());
        return properties;
    }

    @Override
    public Properties getObject() throws Exception {
        return properties;
    }

    @Override
    public Class<?> getObjectType() {
        return Properties.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
