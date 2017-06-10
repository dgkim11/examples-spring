package example.spring.profile.beans;

import org.springframework.context.annotation.Profile;

/**
 * User : Dongle (Dongkyun)
 * Date : 5/13/17
 */
@Profile("develop")
public class EmployeeServiceDevImpl implements EmployeeService   {
    @Override
    public void increaseSalary(long empId, long amount) {
        System.out.println(String.format("increased Salary for empId:%d in the develop zone."));
    }
}
