package example.spring.profile.controller;

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

    @RequestMapping(value = "/president", method = RequestMethod.GET)
    public ModelAndView viewPresident()   {
        ModelAndView mv = new ModelAndView("president");
        mv.addObject("name", president.getName());
        mv.addObject("salary", president.getSalary());

        return mv;
    }
}
