package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class MainController {




    @RequestMapping("/")
    public String createResume(Model model) {
        model.addAttribute("resume",new Resume());
        return "resumeform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Resume resume,BindingResult result) {
        if (result.hasErrors()){

            return "resumeform";
        }

        return "confirm";
    }
}
