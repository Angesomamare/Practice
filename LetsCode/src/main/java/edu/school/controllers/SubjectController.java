package edu.school.controllers;

/**
 * Created by mezgeboa on 10/17/2016.
 */

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import edu.school.dao.*;
import edu.school.models.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class SubjectController {
//    @Autowired
//    @Qualifier(value = "subjectDao")
//    private DAO subDao;
    @Autowired

    @Qualifier(value = "GenericDao")
    private GenericDAO GenericDao;

//    @Autowired
//    @Qualifier(value = "dao")
//    private TempInterface dao;


    @GetMapping("/addSubject")
    public String getSubjectform(Model model) {
        model.addAttribute("subject", new Subject());

        return "add_subject";
    }

    @PostMapping("/addSubject")
    public String /*ModelAndView*/ saveSubject(@Valid Subject subject, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "add_student";
        }

        GenericDao.saveOrUpdateRecord(subject);

        model.addAttribute("success", "Subject " + subject.getSubject_name() + " registered succesfullly");
        return "success";
    }


}