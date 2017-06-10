package example.spring.data.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

/**
 * This Spring configuration contains the basic steps to use Spring Data.
 * You need to creates TransactionManager and EntityManagerFactoryBean beans.
 * In addition, you need to mark EnableJpaRepositories annotation to configure Spring Data.
 *
 * User : Dongle (Dongkyun)
 * Date : 2016. 10. 8.
 */
@Configuration
@EnableJpaRepositories(basePackages = {"example.spring.data.repository"})
@EnableTransactionManagement
public class SpringConfig {
    /**
     * You have to create a default PlatformTransactionManager object for Spring to
     * manage transactions.
     *
     * @param emf Spring injects a default EntityManagerFactory object.
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf)	{
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(emf);
        return txManager;
    }
    /**
     * You have to create a default EntityManagerFactory instance.
     * The following code is the standard, which creates a LocalContainerEntityManagerFactoryBean object.
     *
     * @return
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory()	{
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setPersistenceUnitName("example.jpa.transaction");
        return bean;
    }
}
