package edu.school.models;

import javax.persistence.*;

/**
 * Created by ziwuitu on 10/22/16.
 */
@Entity
@Table(name = "studentGradeSectionRelation")

public class StudentGradeSectionRelation {

    private  int student_grade_section_id;
    private  int student_id_number;
    private int grade_section_id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_grade_section_id")
    public int getStudent_grade_section_id() {
        return student_grade_section_id;
    }

    public void setStudent_grade_section_id(int student_grade_section_id) {
        this.student_grade_section_id = student_grade_section_id;
    }

    public int getStudent_id_number() {
        return student_id_number;
    }

    public void setStudent_id_number(int student_id_number) {
        this.student_id_number = student_id_number;
    }

    public int getGrade_section_id() {
        return grade_section_id;
    }

    public void setGrade_section_id(int grade_section_id) {
        this.grade_section_id = grade_section_id;
    }


}
