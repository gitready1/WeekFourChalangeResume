package com.example.demo;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;


    @NotNull
    @NotEmpty
    private String java;
    @NotNull
    @NotEmpty
    private String sql;

    public Skill() {
    }



    public String getJava() {
        return java;
    }

    public void setJava(String java) {
        this.java = java;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Skill(String skills, String java, String sql) {

        this.java = java;
        this.sql = sql;


    }
}
