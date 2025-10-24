package com;

public class Student {

	private int rollNo;
	private String name;
	private int age;
	private String email;
	private double mark;

	public Student(int rollNo, String name, int age, String email, double mark) {
		this.rollNo = rollNo;
		this.name = name;
		this.age = age;
		this.email = email;
		this.mark = mark;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getMark() {
		return mark;
	}

	public void setMark(double mark) {
		this.mark = mark;
	}


	@Override
	public String toString() {
		return "\nrollNo = " + rollNo + 
				"\nname = " + name + 
				"\nage = " + age + 
				"\nemail = " + email + 
				"\nmark = " + mark+ 
				"\n============================================";
	}
	
	

}
