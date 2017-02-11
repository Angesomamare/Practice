package edu.school.models;

import javax.persistence.*;

/**
 * Created by mezgeboa on 10/31/2016.
 */
@Entity
@Table(name = "teachersubjectrelation")
public class TeacherSubjectRelation {

    private int teacher_subject_id;
    private int teacher_id;
    private int subject_id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_subject_id")

    public int getTeacher_subject_id() {
        return teacher_subject_id;
    }

    public void setTeacher_subject_id(int teacher_subject_id) {
        this.teacher_subject_id = teacher_subject_id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }
}
