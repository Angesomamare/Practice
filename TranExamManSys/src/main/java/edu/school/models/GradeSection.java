package edu.school.models;

import javax.persistence.*;

/**
 * Created by mezgeboa on 10/21/2016.
 */
@Entity
@Table(name="GradeSection")
public class GradeSection {

    private int grade_section_id;
    private int grade;
    private String section;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column

    public int getGrade_section_id() {return grade_section_id;}

    public void setGrade_section_id(int grade_section_id) {this.grade_section_id = grade_section_id;}

    public int getGrade() {return grade;}

    public void setGrade(int grade) {this.grade = grade;}

    public String getSection() {return section;}

    public void setSection(String section) {this.section = section;}
}
