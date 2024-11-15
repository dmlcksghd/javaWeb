package com.firstzone.member;

//DAO도 업무로직 수행 -> DB에 CRUD하는 업무로직
//업무로직 수행 -> DB와 무관하 업무로직
public class MemberService {
	
	MemberDAO mdao = new MemberDAO();
	
	
	public MemberDTO loginService(String mid, String mpass) {
		return mdao.login(mid, mpass);
	}
}
