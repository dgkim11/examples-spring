package example.spring.profile;

import example.spring.profile.beans.EmployeeService;
import example.spring.profile.config.AppConfig;
import example.spring.profile.config.AppConfigForIntegration;
import example.spring.profile.domain.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * User : Dongle (Dongkyun)
 * Date : 5/13/17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { AppConfig.class, AppConfigForIntegration.class })
@ActiveProfiles("integration")
public class EmployeeServiceIntegrationTest {
    @Autowired
    EmployeeService employeeService;

    @Test
    public void testEmployeeService()   {
        Employee emp = new Employee("Dennis", "", 1000);
        employeeService.updateDepartment(emp);
        Assert.assertEquals(emp.getDepartment(),"department-integration");
    }
}
