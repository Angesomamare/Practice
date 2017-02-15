package report.csc493.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import report.csc493.model.phone.phonemodel;
import report.csc493.recurssion.phone.mnemonic;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ziwuitu on 10/17/16.
 */

@Controller
public class HomeController {
    @RequestMapping("/addPhone")
    public String displayAboutUs(ModelMap model) throws Exception{
        model.addAttribute("phonemodel", new phonemodel());

        return "phone";
    }


    @PostMapping("/addPhone")
    public String getSubjectform(@Valid phonemodel phone, mnemonic myphone, Model model) {

        //List<String> num = new ArrayList<>();

        ArrayList<String> num = new ArrayList<String>();

        //phone_mnemonic myphone = new phone_mnemonic();
        List<String> the_word = myphone.provide_words(phone.getPhone());
        for(String x: the_word){

            num.add(x);
        }

        model.addAttribute("about_us", phone.getPhone() +" is your phone number: ");
        model.addAttribute("com", "All possible combinations are "+num );
        model.addAttribute("size", " there are about " + num.size()+ " possible combinations");

        return "about_us";
    }
//    @RequestMapping("/")
//    public String goToHomePage() throws Exception {
//
//        return "introduction";
//    }
//
//    @RequestMapping("/displayIntroduction")
//    public String displayIntroduction() throws Exception {
//
//        return "introduction";
//    }
//
//    @RequestMapping("/displaySocialCulturalBackground")
//    public String displaySocialCulturalBackground() throws Exception {
//
//        return "social_cultural_background";
//    }
//
//    @RequestMapping("/displayEducationalSystem")
//    public String displayEducationalSystem() throws Exception {
//
//        return "educational_system";
//    }
//
//    @RequestMapping("/displayProblemandSolution")
//    public String getProblemandSolution() throws Exception {
//
//        return "problem_solution";
//    }
//    @RequestMapping("/displayDesign")
//    public  String getDesign() throws  Exception{
//
//        return "design";
//    }
//    @RequestMapping("/displayToolsUsed")
//    public String getToolesUsed() throws Exception{
//
//        return "tools_used";
//    }
//
//    @RequestMapping("/displayFuturePlan")
//    public String getFuturePlan() throws Exception{
//
//        return "future_plan";
//    }
//    @RequestMapping("/displayResult")
//    public String getResults() throws Exception{
//
//        return "samples";
//    }

}
