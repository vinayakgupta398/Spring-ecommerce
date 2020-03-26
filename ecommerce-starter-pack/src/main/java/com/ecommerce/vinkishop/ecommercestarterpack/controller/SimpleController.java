package com.ecommerce.vinkishop.ecommercestarterpack.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.jar.Attributes;

@Controller
public class SimpleController {

    @Value("$(spring.application.name)")
    String appName;

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("appname",appName);
        return "home";
    }
}
