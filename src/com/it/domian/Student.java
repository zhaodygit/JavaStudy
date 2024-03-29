package com.it.domian;

import java.util.Date;

/**
 * 封装的对象bean
 * @author admin
 *
 */
public class Student {

	private int id;
	private String sname;
	private String gender;
	private String phone;
	private Date birthday;
	private String hobby;
	private String info;
	
	 
	
	public Student() {
		super();
	}
	public Student(String sname, String gender, String phone, Date birthday, String hobby, String info) {
		super();
		this.sname = sname;
		this.gender = gender;
		this.phone = phone;
		this.birthday = birthday;
		this.hobby = hobby;
		this.info = info;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "Student [sname=" + sname + ", gender=" + gender + ", phone=" + phone + ", birthday=" + birthday
				+ ", hobby=" + hobby + ", info=" + info + "]";
	}
	
	
}
