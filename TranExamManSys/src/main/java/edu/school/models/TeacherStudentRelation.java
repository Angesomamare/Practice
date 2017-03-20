package edu.school.models;

import javax.persistence.*;

/**
 * Created by mezgeboa on 10/31/2016.
 */
@Entity
@Table(name = "teacherstudentrelation")
public class TeacherStudentRelation {
    private int teacher_student_id;
    private int teacher_id;
    private int student_id_number;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_student_id")

    public int getTeacher_student_id() {
        return teacher_student_id;
    }

    public void setTeacher_student_id(int teacher_student_id) {
        this.teacher_student_id = teacher_student_id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public int getStudent_id_number() {
        return student_id_number;
    }

    public void setStudent_id_number(int student_id_number) {
        this.student_id_number = student_id_number;
    }
}
