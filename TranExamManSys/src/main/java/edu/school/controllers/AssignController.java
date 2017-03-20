package edu.school.controllers;



import edu.school.dao.GenericDAO;
import edu.school.models.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by ziwuitu on 10/22/16.
 */
@Controller
public class AssignController {


    @Autowired
    @Qualifier("GenericDao")
    private GenericDAO GenericDao;

    @Autowired
    private SessionFactory sessionFactory;



    @GetMapping("/assignStudentOrTeacher")
    public String getAssignForm(ModelMap model) throws Exception {
        List<GradeSection> listGradeSections = GenericDao.list(GradeSection.class);
//        List<Subject> listSubjects = subjectDao.list();

        model.addAttribute("sectionGradeList", listGradeSections);
//        model.addAttribute("subjectlist", listSubjects);
        model.addAttribute("studentGradeSectionRelation", new StudentGradeSectionRelation());



        return "assign";//new ModelAndView("assign", "model", model);
    }

    @GetMapping ("/gradesubject")
    public String getGradeSubjectForm(ModelMap model) throws Exception{
        List<GradeSection> listGradeSections = GenericDao.list(GradeSection.class);

        List<Subject> listSubjects = GenericDao.list(Subject.class);

        model.addAttribute("sectionGradeList", listGradeSections);
        model.addAttribute("subjectlist", listSubjects);
        model.addAttribute("gradeSectionSubjectRelation", new GradeSectionSubjectRelation());
        return "assignsubjectgradesection";
    }

    @GetMapping ("/assignTeacher")

    public String getTeacherGradeSectionSubjectForm(ModelMap model) throws  Exception{
        List<Teacher> listTeachers = GenericDao.list(Teacher.class);
        List<GradeSection> listGradeSection = GenericDao.list(GradeSection.class);
        List<Subject> listSubjects = GenericDao.list(Subject.class);

        model.addAttribute("teachersList", listTeachers);
        model.addAttribute("gradeSectionList", listGradeSection);
        model.addAttribute("subjectsList", listSubjects);
        model.addAttribute("teacherGradeSectionSubjectRelation", new TeacherGradeSectionSubjectRelation());
        return "assign_teacher_grade_section_subject";
    }

    @PostMapping ("/gradesubject")
    public  String savegradesectionsubject(@Valid GradeSectionSubjectRelation gradeSSR, BindingResult result, ModelMap model){
        if (result.hasErrors()){
            return "assignsubjectgradesection";
        }
        GenericDao.saveOrUpdateRecord(gradeSSR);
        model.addAttribute("succes", "Relation "+ gradeSSR.getSubject_id()+ " assigned succesfully");
        return "success";
    }

    @PostMapping("/assignStudentOrTeacher")
    public String /*ModelAndView*/ saveRelation(@Valid StudentGradeSectionRelation studentGSR, BindingResult result, ModelMap model){

        if (result.hasErrors()){
            return "assign";
        }
        GenericDao.saveOrUpdateRecord(studentGSR);
        model.addAttribute("success", "Relation "+ studentGSR.getGrade_section_id()+ " assigned succesfullly");
        return "success";//new ModelAndView("redirect:/");
    }

    @PostMapping ("/assignTeacher")
    public String saveTeacherGradeSectionSubject(@Valid TeacherGradeSectionSubjectRelation teacherGSSR, BindingResult result, ModelMap model){

        if (result.hasErrors()){
            return "assign_teacher_grade_section_subject";
        }
//        GenericDao.saveOrUpdateRecord(teacherGSSR);
        TeacherGradeSectionRelation teachergs = new TeacherGradeSectionRelation();

        TeacherSubjectRelation teacherS = new TeacherSubjectRelation();
//        teachergs.setTeacher_id(teacher_id);
//        teachergs.setGrade_section_id(grade_section_id);
//        GenericDao.saveOrUpdateRecord(teachergs);
        teachergs.setTeacher_id(teacherGSSR.getTeacher_id());
        teachergs.setGrade_section_id(teacherGSSR.getGrade_section_id());
        GenericDao.saveOrUpdateRecord(teachergs);
//
//
        teacherS.setTeacher_id(teacherGSSR.getTeacher_id());
        teacherS.setSubject_id(teacherGSSR.getSubject_id());
//        teacherS.setTeacher_id(teacher_id);
//        teacherS.setSubject_id(subject_id);
        GenericDao.saveOrUpdateRecord(teacherS);


        List<StudentGradeSectionRelation> studentgrade = GenericDao.list(StudentGradeSectionRelation.class);

        for(int i =0; i<studentgrade.size();i++){
            if(teachergs.getGrade_section_id()==studentgrade.get(i).getGrade_section_id()){
                TeacherStudentRelation teacherstudent = new TeacherStudentRelation();
                teacherstudent.setTeacher_id(teachergs.getTeacher_id());
                teacherstudent.setStudent_id_number(studentgrade.get(i).getStudent_id_number());
                GenericDao.saveOrUpdateRecord(teacherstudent);

            }
        }




//        model.addAttribute("success", teacherGSSR.getTeacher_id()+" is teacher "+ teacherGSSR.getSubject_id()+" is subject "+ teacherGSSR.getGrade_section_id()+" is grade");
       model.addAttribute("success", "Relation "+ teachergs.getTeacher_id()+" and "+ teachergs.getGrade_section_id()+" and "+teacherS.getSubject_id()+" assigned succefully");
        return "success";

    }


}
