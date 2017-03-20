package edu.school.controllers;

import edu.school.dao.DAO;
import edu.school.dao.GenericDAO;

import edu.school.models.Student;
import edu.school.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by ziwuitu on 10/17/16.
 */

@Controller
public class TeacherController {

//    @Autowired
//    @Qualifier(value = "teacherDao")
//    private DAO teacherDao;
    @Autowired
    @Qualifier(value = "GenericDao")
    private GenericDAO GenericDao;

    @GetMapping("/addTeacher")
    public String getTeacherForm(Model model) {
        model.addAttribute("teacher", new Teacher());

        return "add_teacher";
    }

    @PostMapping("/addTeacher")
    public String /*ModelAndView*/ saveTeacher(@Valid Teacher teacher, BindingResult result, ModelMap model) {

        if (result.hasErrors()){
            return "add_teacher";
        }
        GenericDao.saveOrUpdateRecord(teacher);
        model.addAttribute("success", "Teacher "+ teacher.getgiven_name()+ " registered succesfullly");
        return "success";//new ModelAndView("redirect:/");
    }

    @RequestMapping(value = { "/allTeachers" }, method = RequestMethod.GET)

    public String listTeacher(ModelMap model) {

        List<Teacher> allTeachers = GenericDao.list(Teacher.class);
        model.addAttribute("allTeachers", allTeachers);
        return "all_teachers";
    }


    @RequestMapping(value = {"/delete-{teacher_id}-teacher"}, method = RequestMethod.GET)
    public String deleteRecord(@PathVariable int teacher_id) {

        Teacher teacher = new Teacher();

        teacher.setteacher_id(teacher_id);
        GenericDao.deleteRecord(teacher);
        return "redirect:/allTeachers";



    }
}
