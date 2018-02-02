package com.example.demo;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Resume {



    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;


    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    @NotEmpty
    private String education;

    private String education2;

    private String education3;


    @NotNull
    @NotEmpty
    private String experience;



    @NotNull
    @NotEmpty
    private String skills;


    public Resume() {
    }


    public Resume(long id, String name, String email, String education, String experience, String skills) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.education = education;
        this.experience = experience;
        this.skills = skills;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }







}
