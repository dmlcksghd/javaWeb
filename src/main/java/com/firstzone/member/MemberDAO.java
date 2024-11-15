package com.firstzone.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	
	String select_login = "select * from member where memeber_id=?";
}
