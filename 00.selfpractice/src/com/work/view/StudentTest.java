package com.work.view;

public class StudentTest {

	public static void main(String[] args) {
		Student park = new Student();
		park.studentName = "박유정";
		park.studentID = 2017;
		
		System.out.println(park.studentName);
		System.out.println(park.getStudentName());
		System.out.println(park.studentName + "님의 학번은 " + 
		park.studentID + "입니다.");
	}

}
