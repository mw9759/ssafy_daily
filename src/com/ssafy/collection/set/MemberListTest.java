package com.ssafy.collection.set;

import java.util.ArrayList;
import java.util.List;

public class MemberListTest {

	public static void main(String[] args) {
		Member m1 = new Member("user1", "password01", "홍길동", "010-1234-1999", "user01@ssafy.com");
		Member m2 = new Member("user2", "password02", "강감찬", "010-1234-2999", "user02@ssafy.com");
		Member m3 = new Member("user3", "password03", "이순신", "010-1234-3999", "user03@ssafy.com");
		Member m4 = new Member("user4", "password04", "김유신", "010-1234-4999", "user04@ssafy.com");
		Member m5 = new Member("user5", "password05", "유관순", "010-1234-5999", "user05@ssafy.com");
		
		/** 회원관리 기능 위한 객체 선언*/
		//인터페이스 타입 다형성 참조변수 사용
		IMemberManager mngr1 = MemberManagerimpl.getInstance();
		//mngr1.isExist("user01"); // 구현 클래스에서 추가 정의한 자식의 멤버 접근 불가.
		
		//구현클래스 타입 참조변수 사용.
		MemberManagerimpl mngr = MemberManagerimpl.getInstance();
		
		//등록
		System.out.println("--등록--");
		try {
			mngr.addMember(m1);
			System.out.println(m1.getMemberId()+" 회원 등록 완료.");
			
			mngr.addMember(m2);
			System.out.println(m2.getMemberId()+" 회원 등록 완료.");

			mngr.addMember(m3);
			System.out.println(m3.getMemberId()+" 회원 등록 완료.");

			mngr.addMember(m4);//위에서 에러떠서 처리안댐.
			System.out.println(m4.getMemberId()+" 회원 등록 완료.");

			mngr.addMember(m5);
			System.out.println(m5.getMemberId()+" 회원 등록 완료.");

			//mngr.addMember(m3);// 중복 예외 발생.
		} catch (DuplicateException e) {
			// TODO Auto-generated catch block
			System.out.println("[오류] " + e.getMessage());
		}
		
		//전체조회
		System.out.println("--전체 조회--");
		//List<Member> list = mngr.getMemberList();
		//ArrayList<Member> list = mngr.getMemberList();
		for(Member list : mngr.getMemberList()) {
			System.out.println(list);
		}
		
		//아이디로 상세조회
		System.out.println("--user3 조회--");
		try {
			System.out.println(mngr.getMember("user3"));
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("[실패] "+ e.getMessage());
		}
		
		//회원정보변경
		System.out.println("--user4 정보변경--");
		Member dto = new Member("user4", "password04", "손민우", "010-8242-0785", "yoyoyo09094@gmail.com");
		try {
			System.out.println(mngr.setMember(dto));
		} catch (RecordNotFoundException e) {
			System.out.println("[오류] " + e.getMessage());
		}
		
		//비밀번호 변경
		System.out.println("--user4 비밀번호 변경--");
		try {
			mngr.setMemberPw("user4", "password04", "sonminwoo0509");
			System.out.println("[성공] user4님의 비밀번호 변경이 완료되었습니다.");
		} catch (RecordNotFoundException e) {
			System.out.println("[오류] "+e.getMessage());
		} catch (InvalidDataException e) {
			System.out.println("[오류] "+e.getMessage());
		}
		
		//유저삭세
		System.out.println("--user5 유저 삭제--");
		try {
			mngr.removeMember("user5", "password05");
			System.out.println("[성공] user5님의 계정이 삭제되었습니다.");
		} catch (RecordNotFoundException e) {
			System.out.println("[실패] " + e.getMessage());
		} catch (InvalidDataException e) {
			System.out.println("[실패] " + e.getMessage());
		}
		
		//삭제 후 전체 유저조회
		System.out.println("--삭제 후 전체 유저조회--");
		for(Member list : mngr.getMemberList()) {
			System.out.println(list);
		}
	}
}