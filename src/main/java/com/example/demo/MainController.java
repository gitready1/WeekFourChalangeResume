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

    //String defaultimage = "http://staceythewriter.com/temp/wp-content/uploads/2012/04/logo.jpg";


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

            return "resume";
        }
        resumeRepository.save(resume);
        return "redirect:/";

    }

    @RequestMapping("/update/resume/{id}")
    public String updateResume(@PathVariable("id") long id, Model model) {
        model.addAttribute("resume", resumeRepository.findOne(id));
        return "confirm";

    }

    @GetMapping("/resume")
    public String resumeCheck(Model model) {


        return "resume";
    }

    @GetMapping("/login")
    public String Usercheck(Model model) {


        return "login";
    }
    @GetMapping("/summary")
    public String Summary(Model model) {


        return "summary";
    }

    @GetMapping("/refrence")
    public String Refrence(Model model) {


        return "refrence";
    }

    @GetMapping("/coverletter")
    public String CoverLetter(Model model) {


        return "coverletter";}

    @GetMapping("/contact")
    public String Contact(Model model) {


        return "contact";
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






    @RequestMapping("/update/education/{id}")
    public String updateEducation(@PathVariable("id") long id, Model model) {
        model.addAttribute("education", educationRepository.findOne(id));
        return "educationform";

    }




//    @RequestMapping("/experience/{id}")
//    public String updateExperience(@PathVariable("id") long id, Model model) {
//        model.addAttribute("experience", experienceRepository.findOne(id));
//        return "experienceform";
//
//    }
//
//    @RequestMapping("/editskill/{id}")
//    public String updateSkill(@PathVariable("id") long id, Model model) {
//        model.addAttribute("skill", skillsRepository.findOne(id));
//        return "skillform";
//
//    }
}






