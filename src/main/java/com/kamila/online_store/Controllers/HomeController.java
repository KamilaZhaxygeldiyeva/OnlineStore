package com.kamila.online_store.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/index")
@Controller
public class HomeController {
    @GetMapping
    public String showIndex(){
        return "index";
    }
}
