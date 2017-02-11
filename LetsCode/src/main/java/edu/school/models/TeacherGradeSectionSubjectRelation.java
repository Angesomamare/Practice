package edu.school.models;

import javax.persistence.*;

/**
 * Created by mezgeboa on 10/29/2016.
 */
@Entity
@Table(name="TeacherGradeSectionSubjectRelation")
public class TeacherGradeSectionSubjectRelation {
    private int teacher_gradesection_subject_id;
    private  int teacher_id;
    private  int grade_section_id;
    private  int subject_id;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="teacher_gradesection_subject_id")

    public int getTeacher_gradesection_subject_id() {
        return teacher_gradesection_subject_id;
    }

    public void setTeacher_gradesection_subject_id(int teacher_gradesection_subject_id) {
        this.teacher_gradesection_subject_id = teacher_gradesection_subject_id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public int getGrade_section_id() {
        return grade_section_id;
    }

    public void setGrade_section_id(int grade_section_id) {
        this.grade_section_id = grade_section_id;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }
}
