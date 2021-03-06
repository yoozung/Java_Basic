package com.work.view;

import java.util.ArrayList;

import com.work.exception.DuplicateException;
import com.work.exception.RecordNotFoundException;
import com.work.model.dto.Member;
import com.work.model.service.MemberService;

/**
 * <pre>
 * 회원관리시스템 테스트 클래스
 * </pre>
 * @author ParkYuJung
 * @version ver.1.0
 * @since jdk1.8
 */

public class Test {
	
	/**
	 * 회원관리시스템 테스트 메서드
	 * -- 회원등록(아이디, 비밀번호, 이름, 휴대폰, 이메일) : 사용자 입력
	 * -- service(model) : 사용자입력정보 + 시스템(가입일 현재날짜, 등급 일반회원, [+ 마일리지정책 가입시 1000]) 
	 * @param args
	 * @throws DuplicateException 
	 */
	public static void main(String[] args)  { 
		print("회원관리 서비스 이용위한 객체 생성");
		MemberService service = new MemberService();
		
		try {
			print("초기화 회원 등록 : " + service.initMember());
		} catch (DuplicateException e) {
			System.out.println(e.getMessage());
		}
		
		print("회원등록");
		Member dto = new Member("아이디", "비밀번호", "이름", "휴대폰", "이메일");
		try {
			service.addMember("test01", "pass", "이재", "010-1000-2000", "ds@work.com");
			service.addMember("test02", "pass2", "이재머", "010-1000-2000", "ds@work.com");	
			
			// 중복오류 발생
			service.addMember("test01", "pass2", "이재", "010-1000-2000", "ds@work.com");
		
			// 회원 추가 등록 : 위에 있는 코드에서 수행시에 예외가 발생하면 catch 처리로 이동하고 다시 백도하지 않음 : 수행되지 않음
			service.addMember("test03", "pass2", "테스터", "010-1000-2000", "ds@work.com");	
		
		} catch (DuplicateException e) {
			System.out.println(e.getMessage());
		}
		
		print("현재 등록회원수 : " + service.getCount());
		
		print("전체회원 조회");
		ArrayList list = service.getMember();
		for (int index = 0; index < list.size(); index++) {
			System.out.println(list.get(index));
		}
		
		print("회원 상세조회 : user01");
		Member dto1 = null; // 지역변수는 사용전에 반드시 명시적으로 초기화 설정
		try {
			dto1 = service.getMember("user01");
			System.out.println(dto1);
		} catch (RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}

		print("회원 상세조회 : 신규등록 회원 test01");
		try {
			dto1 = service.getMember("test01");
			System.out.println(dto1);
		} catch (RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
	
		print("user01 전체정보 변경");
		//dto = new GeneralMember("user01", "", ""); 이런식으로도 가능
		try {
			dto = service.getMember("user01");
		} catch (RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}  
		
		print("변경전 user01 정보 : " + dto1);
		dto.setName("김은경");
		dto.setMemberPw("passwordmodify");
		dto.setMobile("010-5169-1154");
		
		print("전체정보 변경");
		try {
			dto1 = service.getMember("user01");
		} catch (RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			dto = service.getMember("user01");
		} catch (RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		print("변경후 user01 정보 : " + dto);
				
		print("미존재 회원 아이디 변경");
		dto = new Member("xxxx", "password01", "홍길동", "01012341000", "user01@work.com", "2020-12-15", "G", 50000, null);
		
		try {
			service.setMember(dto);
			System.out.println(service.getMember("xxxx"));
		} catch (RecordNotFoundException e) {
			System.out.println(e.getMessage());
		} 
		
		print("비밀번호 변경전 조회 : ");
		try {
			dto = service.getMember("user02");
		} catch (RecordNotFoundException e) {
			System.out.println(e.getMessage());
		} System.out.println(dto);
		
		print("비밀번호변경");
		try {
			service.setMemberPw("user02", "password02", "goodluck");
			System.out.println("비밀번호 정상 변경처리되었습니다.");
		} catch (RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			dto = service.getMember("user02");
			System.out.println(dto);
		} catch (RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}  
			System.out.println(dto);
		
		print("user01");
		try {
			System.out.println(service.getMember("user01"));
		} catch (RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			dto = service.removeMember("user01", "happy2021");
			System.out.println("[탈퇴성공]" + dto.getName() + "님 그동안 서비스를 이용해주셔서 감사합니다.");
		} catch (RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	/**
	 * 테스트출력 간략화 메서드
	 * @param message 출력 메세지 
	 */
		public static void print(String message) {
		System.out.println("\n###" + message);
	}
}	
	
