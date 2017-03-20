package edu.school.models;

import javax.persistence.*;

@Entity
@Table(name = "Student")
public class Student {

//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private int student_id;

	private int student_id_number;
	private String given_name;
	private String father_name;
	private String grand_father_name;
	private String gender;
	private String address;
	private String date_of_birth;
	private int age;
	private String section;
	private int grade_level;

//	public int getstudent_id() {
//		return student_id;
//	}
//
//	public void setstudent_id(int student_id) {
//		this.student_id = student_id;
//	}

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

    public int getGrade_level() {
        return grade_level;
    }

    public void setGrade_level(int grade_level) {
        this.grade_level = grade_level;
    }

	public String getsection() {
		return section;
	}
	public void setsection(String section) {
		this.section = section;
	}


	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id_number")
    public int getStudent_id_number() {
        return student_id_number;
    }
    public void setStudent_id_number(int student_id_number) {
        this.student_id_number = student_id_number;
    }

}
