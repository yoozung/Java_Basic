package com.work.view;


	public class Student {
		
	int studentID;
	String studentName;
	int grade;
	String address;
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String name) {
		studentName = name; 
	}
	
	public void setStudentID(int id) {
		studentID = id; 
	}
	
	public static void main(String[] args) {
		Student park = new Student();
		park.studentName = "박유정";
		
		System.out.println(park.studentName);
		System.out.println(park.getStudentName());
	}
	
	
}
