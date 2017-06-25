package example.spring.profile.controller;

import example.spring.profile.beans.EmployeeService;
import example.spring.profile.domain.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * User : Dongle (Dongkyun)
 * Date : 6/5/17
 */
@Controller
public class EmployeeController {
    @Resource
    private Employee president;
    @Resource
    private EmployeeService employeeService;

    @RequestMapping(value = "/president", method = RequestMethod.GET)
    public ModelAndView viewPresident()   {
        ModelAndView mv = new ModelAndView("president");
        mv.addObject("name", president.getName());
        mv.addObject("salary", president.getSalary());

        return mv;
    }

    @RequestMapping(value = "/employee/update", method = RequestMethod.GET)
    public ModelAndView updateEmployee()    {
        ModelAndView mv = new ModelAndView("employee/update");
        Employee employee = new Employee("Dennis", "department", 1000);
        employeeService.updateDepartment(employee);
        mv.addObject("employee", employee);

        return mv;
    }
}
