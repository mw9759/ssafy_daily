package com.ssafy.collection.set;

import java.util.Set;
/**회원관리 기능에 대한 인터페이스*/
public interface IMemberManager {
	/**등록 메서드*/
	public void addMember(Member dto) throws DuplicateException;
	/**조회 메서드: 전체조회*/
	public Set<Member> getMemberList();
	/**조회 메서드: 회원 상세조회*/
	public Member getMember(String memberId) throws RecordNotFoundException;
	/**변경 메서드: 해당 회원의 전체 정보 변경*/
	public Member setMember(Member dto) throws RecordNotFoundException;
	/**변경 메서드: 비밀번호*/
	public void setMemberPw(String memberId, String memberPw, 
			String modifyMemberPw) throws RecordNotFoundException, InvalidDataException;
	/**삭제 메서드*/
	public Set<Member> removeMember(String MemberId, String MemberPw) 
			throws RecordNotFoundException, InvalidDataException;
}
