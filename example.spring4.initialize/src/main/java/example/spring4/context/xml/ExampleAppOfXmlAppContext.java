package example.spring4.context.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This example shows how to create a Spring based application by using xml configuration.
 * First, you need to create an xml file containing spring context configuration in your class path.
 * In this example, you can find this file in META-INF/spring directory.
 * Then, you create an instance of ClassPathXmlApplicationContext class with the parameter describing 
 * the xml file path. 
 * 
 * @author Dennis
 *
 */
public class ExampleAppOfXmlAppContext {
	public static void main(String[] args)	{
		ExampleAppOfXmlAppContext theApp = new ExampleAppOfXmlAppContext();
		theApp.execute();
	}
	
	private void execute()	{
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext.xml");
		Hello hello = context.getBean("hello", Hello.class);
		System.out.println(hello.hello());
	}
}
