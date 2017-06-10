package example.spring.profile.beans;

import org.springframework.beans.factory.annotation.Value;

/**
 * User : Dongle (Dongkyun)
 * Date : 5/13/17
 */
public class PropertyService {
    @Value("#{systemProperties.targetDatabase")     // get from systemProperties which is an implicit object.
    private String targetDatabase;
    @Value("#{strategyBean.encryptMethod")          // strategyBean is a Spring bean
    private String encryptMethod;
    @Value("#{myProperties['security.authId']")     // security is a bean that extends Properties class.
    private String authId;
}
