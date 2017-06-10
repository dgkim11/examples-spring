package example.spring.profile.beans;

/**
 * User : Dongle (Dongkyun)
 * Date : 5/13/17
 */
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public void increaseSalary(long empId, long amount) {
        System.out.println(String.format("increased Salary for empId:%d and store it into RDS database."));
    }
}
