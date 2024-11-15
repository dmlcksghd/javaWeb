package com.firstzone.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBUtil;

public class MemberDAO {
	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	
	String select_login = "select * from members where member_ID=?";
	
	public MemberDTO login(String mid, String mpass) {
		MemberDTO member = null;
		conn = DBUtil.getConnection();
		try {
			st = conn.prepareStatement(select_login);
			st.setString(1, mid);
			rs = st.executeQuery();
			
			if(rs.next()) {
				String getPass = rs.getString("member_pass");
				if(mpass.equals(getPass)) {
					member = MemberDTO.builder()
							.member_id(mid)
							.member_pass(mpass)
							.member_name(rs.getString("member_name"))
							.member_email("member_email")
							.build();
				} else {
					member = MemberDTO.builder()
							.member_id("-1")
							.build();
				}
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return member;
	}
}
