package example.spring4.database.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

/**
 * If you want to enable Spring's annotation-driven transaction management, you need to specify the 
 * default  PlatformTransactionManager bean to be used for annotation-driven transaction management.
 * One reason this might be necessary is if there are two PlatformTransactionManager beans present in the container. 
 * 
 * @author Dennis
 *
 */
@EnableTransactionManagement
public class TxManagementConfig implements TransactionManagementConfigurer	{

	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
	}

	@Bean
	public DataSource dataSource()	{
		BasicDataSource
	}
}
