package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("/mist")
public class MainController {
    @GetMapping("/")
    public String mainMessage(Model model){
        model.addAttribute("cloth", Arrays.asList(new Clothes("djjs", "dress", 12900),
                new Clothes("djjs", "dress", 12900),
                new Clothes("djjs", "dress", 12900)));
        return "main_page";
    }
}
