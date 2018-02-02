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
//Issue: Problem recognizing errors, need to fix
            return "confirm";
        }


        resumeRepository.save(resume);
        return "redirect:/";

    }








       /* @GetMapping("/add")
        public String ResumeForm(Model model) {

            model.addAttribute("resume", new Resume());
            return "resumeform";*/

          /*  @RequestMapping("/detail/{id}")
            public String showPeople(@PathVariable("id") long id, Model model) {
                model.addAttribute("people", resumeRepository.findOne(id));
                return "peopleform";
        model.addAttribute("resume",new Resume());
        return "peopleform";
    }

    @RequestMapping("/add")
    public String addEducation(Model model){
        model.addAttribute("resume", new Resume());
        return "resumeform";
    }

    @PostMapping("/add")
    public String processEducation(@Valid @ModelAttribute ("resume") Resume resume, BindingResult result, Model model){
        if (result.hasErrors()){
            return "resumeform";
        }
        //here save to database

        return "redirect:/";
        model.addAttribute("resume", resume);
        return "resumeform";*/
    }






