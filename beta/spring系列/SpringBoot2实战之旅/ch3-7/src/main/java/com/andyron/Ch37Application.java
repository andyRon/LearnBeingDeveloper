package com.andyron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Locale;

@SpringBootApplication
@Controller
public class Ch37Application {
    @Autowired
    private MessageSource messageSource;

    public static void main(String[] args) {
        SpringApplication.run(Ch37Application.class, args);
    }

    @GetMapping("/")
    public String index(Model model) {
        Locale locale = LocaleContextHolder.getLocale();
        model.addAttribute("message", messageSource.getMessage("message", null, locale));
        return "index";
    }
}
