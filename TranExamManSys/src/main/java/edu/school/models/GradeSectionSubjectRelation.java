package edu.school.models;

import javax.persistence.*;

/**
 * Created by mezgeboa on 10/26/2016.
 */
@Entity
@Table(name="GradeSectionSubjectRelation")

public class GradeSectionSubjectRelation {
    private int grade_section_subject_id;
    private int grade_section_id;
    private int subject_id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="grade_section_subject_id")
    public int getGrade_section_subject_id() {
        return grade_section_subject_id;
    }

    public void setGrade_section_subject_id(int grade_section_subject_id) {
        this.grade_section_subject_id = grade_section_subject_id;
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
