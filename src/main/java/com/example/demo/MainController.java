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

    @Autowired
    EducationRepository educationRepository;

    @Autowired
    ExperienceRepository experienceRepository;

    @Autowired
    SkillsRepository skillsRepository;


    @RequestMapping("/")
    public String listResume(Model model) {
        model.addAttribute("resumes", resumeRepository.findAll());
        return "confirm";
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

    @RequestMapping("/a")
    public String listEducation(Model model) {
        model.addAttribute("educations", educationRepository.findAll());
        return "confirm";
    }

    @GetMapping("/education")
    public String educationForm(Model model) {

        model.addAttribute("education", new Education());
        return "educationform";
    }

    @PostMapping("/educationprocess")
    public String educationProcessForm(@Valid @ModelAttribute("education") Education education, BindingResult result, Model model) {
        if (result.hasErrors()) {

            return "confirm";
        }
        educationRepository.save(education);
        return "redirect:/a";
    }


    @RequestMapping("/b")
    public String listexperience(Model model) {
        model.addAttribute("experiences", experienceRepository.findAll());
        return "confirm";
    }

    @GetMapping("/experience")
    public String experienceForm(Model model) {

        model.addAttribute("experience", new Experience());
        return "experienceform";
    }

    @PostMapping("/experienceprocess")
    public String experienceProcessForm(@Valid @ModelAttribute("experience") Experience experience, BindingResult result, Model model) {
        if (result.hasErrors()) {

            return "confirm";
        }
        experienceRepository.save(experience);
        return "redirect:/b";
    }


    @RequestMapping("/c")
    public String listskills(Model model) {
        model.addAttribute("skills", skillsRepository.findAll());
        return "confirm";
    }


    @GetMapping("/skill")
    public String skillForm(Model model) {

        model.addAttribute("skill", new Skill());
        return "skillform";
    }

    @PostMapping("/skillprocess")
    public String SkillsProcessForm(@Valid @ModelAttribute("skill") Skill skill, BindingResult result, Model model) {
        if (result.hasErrors()) {

            return "confirm";
        }
        skillsRepository.save(skill);
        return "redirect:/c";
    }


}






