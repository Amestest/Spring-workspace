package com.khmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khmall.dto.Member;
import com.khmall.mapper.LoginMapper;

@Service
public class MemberService {
	
	@Autowired
	private LoginMapper memberMapper;
	
	public Member getLogin(String member_name, String member_phone) {
		// 추후에 서비스에다가 비밀번호 암호화해서 DB에 저장하고
		// 암호화된 비밀번호를 가져와서 로그인하는 코드를 추가로 작성할 예정
		
		return memberMapper.getLogin(member_name, member_phone);
	}
	
	// void는 return이 없다! void는 통보하는 것이기 때문에 전달하지 않음
	public void updateMember(Member member) { 
		memberMapper.updateMember(member);
	}
	
	// 삭제는 통보다 = void != return
	public void deleteMember(int member_id) {
		memberMapper.deleteMember(member_id);
	}
	
	public List<Member> searchMembers(String keyword){
		return memberMapper.searchMembers(keyword);
	}
	
}