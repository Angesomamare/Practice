package edu.school.models;

import javax.persistence.*;

/**
 * Created by mezgeboa on 10/24/2016.
 */
@Entity
@Table(name="StudentSubjectRelation")

public class StudentSubjectRelation {
    private int student_subject_id;
    private int student_id_number;
    private int subject_id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="student_subjcet_id")
    public int getStudent_subject_id() {
        return student_subject_id;
    }

    public void setStudent_subject_id(int student_subject_id) {
        this.student_subject_id = student_subject_id;
    }
    public int getStudent_id_number() {
        return student_id_number;
    }
    public void setStudent_id_number(int student_id_number) {
        this.student_id_number = student_id_number;
    }
    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }
}
