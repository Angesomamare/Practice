package edu.school.controllers;

import edu.school.dao.*;
import edu.school.models.*;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller

public class StudentController {
    @Autowired
    private SessionFactory studentSessionFactory;

    @Autowired
    @Qualifier(value = "GenericDao")
    private GenericDAO GenericDao;

	@GetMapping("/addStudent")
	public String getStudentForm(Model model) {
		model.addAttribute("student", new Student());

		return "add_student";
	}

	@Transactional
	@PostMapping("/addStudent")
    public String /*ModelAndView*/ saveStudent(@Valid Student student, BindingResult result, ModelMap model){
        if (result.hasErrors()){
            return "add_student";
        }

        List<GradeSection> retrievedGradeList = GenericDao.list(GradeSection.class);

        List<GradeSectionSubjectRelation> retrievedGradeSubjectList;

        if(retrievedGradeList != null) {

            //for(GradeSection gs : retrievedGradeList) {
            for(int i = 0; i < retrievedGradeList.size(); i++) {
                if (retrievedGradeList.get(i).getGrade() == student.getGrade_level() && retrievedGradeList.get(i).getSection().equals( student.getsection())) {
                    GenericDao.saveOrUpdateRecord(student); //save student
                    //create student grade_section relation:
                    StudentGradeSectionRelation stuGra = new StudentGradeSectionRelation();
                    stuGra.setGrade_section_id(retrievedGradeList.get(i).getGrade_section_id());

                    stuGra.setStudent_id_number(student.getStudent_id_number());
                    GenericDao.saveOrUpdateRecord(stuGra);

                    retrievedGradeSubjectList = GenericDao.list(GradeSectionSubjectRelation.class);
                    for(GradeSectionSubjectRelation gradeSubject : retrievedGradeSubjectList) {
                        if (gradeSubject.getGrade_section_id() == retrievedGradeList.get(i).getGrade_section_id()){
                            //create student subject relation
                            StudentSubjectRelation studentSubject = new StudentSubjectRelation();
                            studentSubject.setStudent_id_number(student.getStudent_id_number());
                            studentSubject.setSubject_id(gradeSubject.getSubject_id());
                            GenericDao.saveOrUpdateRecord(studentSubject);
                        }
                    }
                }
            }
        }
        return "redirect:/allStudents";//new ModelAndView("redirect:/");
    }

    @Transactional
   @RequestMapping(value = { "/allStudents" }, method = RequestMethod.GET)

    public String listStudent(ModelMap model) {

        List<Student> allStudents = GenericDao.list(Student.class);
        model.addAttribute("allStudents", allStudents);
        return "all_students";
    }

    @GetMapping("/search")
    public String displaySearchPage(){

        return "search";
    }

    @Transactional
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(Model model, @RequestParam("student_id_number") int student_id_number) {

        List<Student> searchResult = new ArrayList<Student>();
        searchResult.add((Student) studentSessionFactory.getCurrentSession()
                .createCriteria(Student.class).add(Restrictions.eq("student_id_number", student_id_number))
                .uniqueResult());

        model.addAttribute("searchResult", searchResult);
        model.addAttribute("inputSearch", student_id_number);
        System.out.println(searchResult.get(0).getgiven_name());
        return "search";
    }


    @RequestMapping(value = {"/edit-student-{student_id_number}"}, method = RequestMethod.GET)
    public String editStudent(@PathVariable int student_id_number, ModelMap model) {
        Student student = (Student) GenericDao.retrieveRecord(Student.class, student_id_number);
        model.addAttribute("student", student);
        model.addAttribute("edit", true);
        return "add_student";
    }


    @Transactional
    @RequestMapping(value = {"/delete-student-{student_id_number}"}, method = RequestMethod.GET)
    public String deleteStudent(@PathVariable int student_id_number) {

        Student student = new Student();
        student.setStudent_id_number(student_id_number);
        GenericDao.deleteRecord(student);
        return "redirect:/allStudents";

    }


}
