package example.spring.profile.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Properties;

/**
 * User : Dongle (Dongkyun)
 * Date : 6/10/17
 */
@Component
public class UrlBuilder {
    @Value("${app.server.host}")
    private String host;
    @Value("${app.server.port}")
    private String port;
    @Value("${app.server.protocol}")
    private String protocol;
    @Value("${app.server.description}")
    private String description;

    @Resource(name = "proxyProperties")
    private Properties proxyProps;

    @Autowired
    private Environment env;

    public String getUrl()  {
        return protocol + "://" + host + ":" + port;
    }
    public String getDescription()  {
        return description;
    }
    public String getProxyUrl() {
        return proxyProps.getProperty("proxy.server.host");
    }
    /**
     * You can also get the same properties from Environment object.
     *
     * @return
     */
    public String getUrlFromEnv()   {
        return env.getProperty("app.server.protocol") +
                "://" + env.getProperty("app.server.host") +
                ":" + env.getProperty("app.server.port");
    }
    public String getDescriptionFromEnv()   {
        return env.getProperty("app.server.description");
    }
}
