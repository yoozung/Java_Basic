package com.work.view;

public class LoopTest {

	/*  ----- 1~5 까지 출력 ------
	 * 1. for구문
	 * 2. while 
	 * 3. do~ while
	 */
	public static void main(String[] args) {
		int total = 0;
		System.out.println("for 구문");
		for (int i = 1; i <= 5; i++) {
		System.out.println(i);
			total += i;
	}
	System.out.println("total = " + total);
	
	total = 0;
	System.out.println("/n2. while 구문");
	int i =1;
	while (i <= 5) {
		System.out.println(i);
		total += i;
		i++;
	}
	System.out.println("total = " + total);
	}
//	total = 0;
//	i = 1;
//	System.out.println("/n3. do ~ while 구문");
//	do {
//		System.out.println(i);
//		total += i;
//	}
	
	
	
	
	
	
	
	public static void main2(String[] args) {
		//영문 대문자에 대한 아스키코드를 출력하는 프로그램 작성
		//힌트 : 알파벳은 26자, type casting (형변환)
		
		for (int i = 'A'; i <= 'Z'; i++  ) {
		System.out.println((char)i + " : " + i);
	}
	}
	
	
	
	public static void main1(String[] args) {
	//짝수만 출력하고 누적 출력
		int total = 0;
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
			System.out.println(i);
			total += i;
		}
		}System.out.println("total : " + total);
	}

}
