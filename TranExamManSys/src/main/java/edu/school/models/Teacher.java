package edu.school.models;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "Teacher")
public class Teacher {

    private int teacher_id;
    private String given_name;
    private String father_name;
    private String grand_father_name;
    private String gender;
    private String address;
    private String date_of_birth;
    private int age;
    private int grade_level_section_assigned;
    //private String section;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    public int getteacher_id() {
        return teacher_id;
    }
    public void setteacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getgiven_name() {
        return given_name;
    }
    public void setgiven_name(String given_name) {
        this.given_name = given_name;
    }

    public String getfather_name() {
        return father_name;
    }
    public void setfather_name(String father_name) {
        this.father_name = father_name;
    }

    public String getgrand_father_name() {
        return grand_father_name;
    }
    public void setgrand_father_name(String grand_father_name) {
        this.grand_father_name = grand_father_name;
    }

    public String getgender() {
        return gender;
    }
    public void setgender(String gender) {
        this.gender = gender;
    }

    public String getaddress() {
        return address;
    }
    public void setaddress(String address) {
        this.address = address;
    }

    public String getdate_of_birth() {
        return date_of_birth;
    }
    public void setdate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public int getage() {
        return age;
    }
    public void setage(int age) {
        this.age = age;
    }

    public int getgrade_level_section_assigned() {
        return grade_level_section_assigned;
    }
    public void setgrade_level_section_assigned(int grade_level_section_assigned) {
        this.grade_level_section_assigned = grade_level_section_assigned;
    }
	/*public String getsection() {
		return section;
	}*/
	/*public void setsection(String section) {
		this.section = section;
	}*/

/*	public static ArrayList<String> getteacher_fields() {
		ArrayList<String> ls = new ArrayList<>();
		ls.add("teacher_id");
		ls.add("given_name");
		ls.add("father_name");
		ls.add("grand_father_name");
		ls.add("gender");
		ls.add("age");
		ls.add("address");
		ls.add("grade_level");
		ls.add("section");
		ls.add("date_of_birth");

		return ls;
	}*/
}
