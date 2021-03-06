package com.work.map;

import java.util.HashMap;
import java.util.Iterator;

import com.work.model.dto.AdminMember;
import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;
import com.work.model.dto.SpecialMember;

public class MapTest {

	public static void main(String[] args) {
		Member dto1 = new GeneralMember("user01", "pppppp", "홍길동", "01012341000", "user01@work.com", "2020-12-15", "G", 5000);
		Member dto2 = new GeneralMember("user02", "password02", "강감찬", "01012342000", "user02@work.com", "2021-12-15", "G", 95000);
		Member dto3 = new SpecialMember("user03", "password03", "이순신", "01012343000", "user03@work.com", "2020-11-15", "S", "강동원");
		Member dto4 = new SpecialMember("user04", "password04", "김유신", "01012344000", "user04@work.com", "2021-01-05", "S", "김하린");
		Member dto5 = new AdminMember("user05", "password05", "유관순", "01012345000", "user05@work.com", "2020-04-01", "A", "선임");
	
		// 회원들을 저장 관리하기 위한 HashMap<K, V>
		// 회원식별속성 : 아이디 => map key
		// HashMap 객체 선언 및 생성
		HashMap<String, Member> map = new HashMap<String, Member>();
		
		print("회원 등록");
		map.put(dto1.getMemberID(), dto1);
		map.put(dto2.getMemberID(), dto2);
		map.put(dto3.getMemberID(), dto3);
		map.put(dto4.getMemberID(), dto4);
		map.put(dto5.getMemberID(), dto5);
		
		print("등록 회원수 조회 : " + map.size());
		
		print("조회 : user01");
		Member dto = map.get("user01");
		System.out.println(dto);
		
		print("변경 : user01");
		dto = new GeneralMember("user01", "password01", "홍길동", "01012341000", "user01@work.com", "2020-12-15", "G", 5000);
		map.put(dto.getMemberID(),dto);
		
		print("변경 후 조회 : user01");
		System.out.println(map.get("user01"));
		
		print("삭제 : user02");
		System.out.println("-삭제회원정보" + map.remove("user02"));
		
		print("전체조회"); 
		/*
		 * 참고 api
		 * -- map에 저장된 모든 객체들의 key : 중복불가 Set
		 * -- map 메서드중에서 반환 타입이 Set인게 있는지 찾아보기 : Set<K> keySet()
		 * -- key 목록을 Set에 반환 받아옴 : Set은 순서가 없고 중복불가
		 * -- key 목록인 Set애 잇는 Key들을 Iterator에 담아오기
		 * -- Iterator를 반복하면서 key를 하나씩 가져오기
		 * -- 가져온 key를 map에 있는 객체를 조회하기 위해서 map.get(key) 해당 key 객체 가져오기
		 */
		Iterator<String> iterator = map.keySet().iterator(); 
		while(iterator.hasNext()) { 
			String key = iterator.next(); 
			Member value = map.get(key); 
			System.out.println(key + " : " + value);
		}
		
	}

	
	private static void print(String message) {
		System.out.println("\n###" + message);
	}

}
