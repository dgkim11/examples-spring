package example.spring4.context.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExampleConfiguration {
	@Bean
	public Hello hello()	{
		return new Hello();
	}
}
