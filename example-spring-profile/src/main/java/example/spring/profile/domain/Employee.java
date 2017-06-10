package example.spring.profile.domain;

/**
 * User : Dongle (Dongkyun)
 * Date : 5/13/17
 */
public class Employee {
    private String name;
    private String department;
    private long salary;

    public Employee() {}
    public Employee(String name, String department, long salary)    {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
