package edu.school.models;

import javax.persistence.*;

/**
 * Created by mezgeboa on 10/31/2016.
 */

@Entity
@Table(name = "TeacherGradeSectionRelation")
public class TeacherGradeSectionRelation {

    private int teacher_grade_section_id;
    private int teacher_id;
    private int grade_section_id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_grade_section_id")
    public int getTeacher_grade_section_id() {
        return teacher_grade_section_id;
    }

    public void setTeacher_grade_section_id(int teacher_grade_section_id) {
        this.teacher_grade_section_id = teacher_grade_section_id;
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
}
