package example.spring.profile.beans;

import example.spring.profile.domain.Employee;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * User : Dongle (Dongkyun)
 * Date : 5/13/17
 */
@Component
@Profile("production")
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public Employee updateDepartment(Employee employee) {
        employee.setDepartment("department-production");
        return employee;
    }
}
