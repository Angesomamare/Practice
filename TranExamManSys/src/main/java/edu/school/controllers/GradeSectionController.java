package edu.school.controllers;

import edu.school.dao.DAO;
import edu.school.dao.GenericDAO;

import edu.school.models.GradeSection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by mezgeboa on 10/21/2016.
 */
@Controller
public class GradeSectionController {
//    @Autowired
//    @Qualifier(value = "gradesectionDao")
//    private DAO gradeSectionDao;
    @Autowired
    @Qualifier(value = "GenericDao")
    private GenericDAO GenericDao;

    @GetMapping("/addGrade")
    public String getGradeSectioform(Model model) {
        model.addAttribute("gradeSection", new GradeSection());

        return "add_grade_section";
    }

    @PostMapping("/addGrade")
    public String /*ModelAndView*/ saveGradeSection(@Valid GradeSection gradeSection, BindingResult result, ModelMap model){
        if (result.hasErrors()){
            return "add_grade_section";
        }
        GenericDao.saveOrUpdateRecord(gradeSection);
        model.addAttribute("success", "Grade "+ gradeSection.getGrade()+" and section "+ gradeSection.getSection()+ " registered succesfullly");
        return "success";//new ModelAndView("redirect:/");
    }

}
