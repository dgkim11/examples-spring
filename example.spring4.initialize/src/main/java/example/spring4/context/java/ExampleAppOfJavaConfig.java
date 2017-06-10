package example.spring4.context.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * This example shows how to create an Spring application with annotation based spring configuration.
 * First, you need to define a Java Configuration class containing beans.
 * In this example, you can find ExampleConfiguration class for that.
 * Then, create an instance of AnnotationConfigApplicationContext class with the parameter describing 
 * the configuration class.
 * 
 * @author Dennis
 *
 */
public class ExampleAppOfJavaConfig {
	public static void main(String[] args)	{
		ExampleAppOfJavaConfig theApp = new ExampleAppOfJavaConfig();
		theApp.execute();
	}
	
	private void execute()	{
		ApplicationContext context = 
				   new AnnotationConfigApplicationContext(ExampleConfiguration.class);
		Hello hello = context.getBean("hello", Hello.class);
		System.out.println(hello.hello());
	}
}
