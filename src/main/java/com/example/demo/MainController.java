package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class MainController {


    @Autowired
    ResumeRepository resumeRepository;

    @RequestMapping("/")
    public String listResume(Model model) {
        model.addAttribute("people", resumeRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String resumeForm(Model model) {

        model.addAttribute("resume", new Resume());
        return "resumeform";
    }


    @PostMapping("/process")
    public String processForm(@Valid @ModelAttribute("resume") Resume resume, BindingResult result, Model model) {
        if (result.hasErrors()) {

            return "confirm";
        }


        resumeRepository.save(resume);
        return "redirect:/";



    }

    @GetMapping("/education")
    public String educationForm(Model model) {

        model.addAttribute("education", new Education());
        return "list";
    }
    @GetMapping("/experience")
    public String experienceForm(Model model) {

        model.addAttribute("experience", new Education());
        return "list";
    }
    public String skillsForm(Model model) {

        model.addAttribute("skills", new Skills());
        return "list";
    }
}





