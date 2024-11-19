package com.firstzone.member;

//DAO: 업무로직, DB에 CRUD
//Service : DB무관한 업무로직   
public class MemberService {

	MemberDAO mdao = new MemberDAO();
	
	public MemberDTO loginService(String mid, String mpass){
		return mdao.login(mid, mpass);
	}
}
