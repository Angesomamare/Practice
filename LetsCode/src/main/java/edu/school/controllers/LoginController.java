package edu.school.controllers;

import edu.school.daoimpl.UserDAOImpl;
import edu.school.models.User;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.security.util.Password;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ziwuitu on 10/26/16.
 */

@EnableAsync(proxyTargetClass = true)
@EnableCaching(proxyTargetClass = true)
/*
*   The bean 'userDao' could not be injected as a 'edu.school.daoimpl.UserDAOImpl' because it is a JDK dynamic proxy that implements:
*        edu.school.dao.DAO
*   Action:
*   Consider injecting the bean as one of its interfaces or forcing the use of CGLib-based proxies by setting proxyTargetClass=true on
*   @EnableAsync and/or @EnableCaching.
 */


@Controller
public class LoginController {
    @Autowired
    private SessionFactory userSessionFactory;

    @Autowired
    @Qualifier(value = "userDao")
    private UserDAOImpl userDao;


    @GetMapping("/authorizeLogin")
    public String getAssignForm(ModelMap model) throws Exception {

        return "login";

        // return new ModelAndView("login", "user", new User());
    }

    @Transactional
    @RequestMapping(value = "/authorizeLogin", method = RequestMethod.POST)
    public String checkAuthorization(Model modelMap,
                                     @RequestParam("user_name") String user_name,
                                     @RequestParam("password") String password) {
        List<User> loginUser = new ArrayList<User>();
        loginUser.add((User) userSessionFactory.getCurrentSession()
                .createCriteria(User.class).add(Restrictions.eq("user_name", user_name))
                .uniqueResult());

        //User loginUser = userDao.getLoginUser(user.getUser_name(), user.getPassword());

        if (loginUser != null && loginUser.size() == 1 && loginUser.get(0).getPassword().equals(password)) {

            modelMap.addAttribute("success", "Successfully logged in!");
            modelMap.addAttribute("loginUserType", loginUser.get(0).getUser_type());

            return "index";
        }

        return "login";

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";

    }

}
