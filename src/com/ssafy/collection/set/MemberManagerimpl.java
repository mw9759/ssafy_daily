package com.ssafy.collection.set;

import java.util.HashSet;
import java.util.Set;

public class MemberManagerimpl implements IMemberManager{
	/** 회원들의 정보를 저장 관리하기 위한 자료 저장구조*/
	private HashSet<Member> set = new HashSet<>();
	
	/*싱글톤. 생성자*/
	public MemberManagerimpl() {}
	/*싱글톤 적용 객체 생성*/
	private static MemberManagerimpl instance = new MemberManagerimpl();
	public static MemberManagerimpl getInstance() {
		return instance;
	}
	
	public boolean isExist(String memberId) {
		for(Member m : set) {
			if(m.getMemberId().equals(memberId)) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public void addMember(Member dto) throws DuplicateException {
		// TODO Auto-generated method stub
		if(isExist(dto.getMemberId())) {
			set.add(dto);
			return;
		}
		throw new DuplicateException(dto.getMemberId());
	}

	@Override
	public Set<Member> getMemberList() {
		// TODO Auto-generated method stub
		return set;
	}

	@Override
	public Member getMember(String memberId) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		if(!(isExist(memberId))) {
			for(Member m : set) {
				if(m.getMemberId().equals(memberId)) {
					return m;
				}
			}
		}else {
			throw new RecordNotFoundException(memberId);
		}
		return null;
	}

	@Override
	public Member setMember(Member dto) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		if(!(isExist(dto.getMemberId()))) {
			for(Member m : set) {
				if(m.getMemberId().equals(dto.getMemberId())) {
					set.remove(m);
					set.add(dto);
					return dto;
				}
			}
		}
		throw new RecordNotFoundException(dto.getMemberId());
	}

	@Override
	public void setMemberPw(String memberId, String memberPw, String modifyMemberPw)
			throws RecordNotFoundException, InvalidDataException {
		// TODO Auto-generated method stub
		
		if(!(isExist(memberId))) {
			for(Member m : set) {
				if(m.getMemberId().equals(memberId)) {
					if(m.getMemberPw().equals(memberPw)) {
						Member m1 = new Member(memberId, modifyMemberPw, m.getName(),
								m.getMobile(), m.getEmail());
						set.remove(m);
						set.add(m1);
						return;
					}else {
						throw new InvalidDataException();
					}
				}
			}
		}else {
			throw new RecordNotFoundException(memberId);
		}
	}

	@Override
	public Set<Member> removeMember(String MemberId, String MemberPw)
			throws RecordNotFoundException, InvalidDataException {
		// TODO Auto-generated method stub
		if(!(isExist(MemberId))) {
			for(Member m : set) {
				if(m.getMemberId().equals(MemberId)) {
					if(m.getMemberPw().equals(MemberPw)) {
						set.remove(m);
						return set;
					}else {
						throw new InvalidDataException();
					}
				}
			}
		}
		
		throw new RecordNotFoundException(MemberId);
	}

}
