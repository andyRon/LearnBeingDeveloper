package com.andyron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Andy Ron
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("msg", "Hello, Andy Ron!");
        return "index";
    }
}
