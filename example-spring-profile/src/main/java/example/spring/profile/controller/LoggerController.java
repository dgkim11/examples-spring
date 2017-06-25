package example.spring.profile.controller;

import example.spring.profile.beans.LogHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * User : Dongle (Dongkyun)
 * Date : 6/5/17
 */
@Controller
public class LoggerController {
    @Resource
    private LogHelper logHelper;

    @RequestMapping(value = "/log/{message}", method = RequestMethod.GET)
    public ModelAndView log(@PathVariable String message)   {
        ModelAndView mv = new ModelAndView("log");
        mv.addObject("logMessage", logHelper.getMessage(message));

        return mv;
    }
}
