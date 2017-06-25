package example.spring.profile.controller;

import example.spring.profile.beans.UrlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * User : Dongle (Dongkyun)
 * Date : 6/5/17
 */
@Controller
public class ServerUrlController {
    @Autowired
    private UrlBuilder urlBuilder;

    @RequestMapping(value = "/server/url", method = RequestMethod.GET)
    public ModelAndView getServerUrl()   {
        ModelAndView mv = new ModelAndView("server/url");
        mv.addObject("url", urlBuilder.getUrl());
        mv.addObject("description", urlBuilder.getDescription());
        mv.addObject("urlFromEnv", urlBuilder.getUrlFromEnv());
        mv.addObject("descriptionFromEnv", urlBuilder.getDescriptionFromEnv());
        mv.addObject("proxyUrl", urlBuilder.getProxyUrl());

        return mv;
    }
}
