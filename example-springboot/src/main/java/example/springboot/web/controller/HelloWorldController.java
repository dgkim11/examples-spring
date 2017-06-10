package example.springboot.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User : Dongle (Dongkyun)
 * Date : 2016. 12. 19.
 */
@RestController
public class HelloWorldController {
    @RequestMapping("/hello")
    public String hello()   {
        return "Hello world";
    }
}
