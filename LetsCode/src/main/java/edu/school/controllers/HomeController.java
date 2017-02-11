package edu.school.controllers;

import edu.school.models.GradeSection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by ziwuitu on 10/17/16.
 */

@Controller
public class HomeController {

    @RequestMapping("/")
    public String /*ModelAndView*/ goToHomePage() throws Exception {
        //List<Student> listUsers = studentDao.list();
        //ModelAndView model = new ModelAndView("UserList");
        //model.addObject("userList", listUsers);
        //return model;
        return "index";
    }

    //AJAX
    @RequestMapping("/ajax")
    public ModelAndView helloAjaxTest() {
        return new ModelAndView("index", "message", "AJAX and jQuery Example");
    }

    @RequestMapping(value = "/getTime", method = RequestMethod.GET)
    public @ResponseBody String getTime() {

        String result = "<br>Today is " + new Date().toString() + "</b>";
        return result;
    }

}
