package com.firstzone.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
	String member_id;
	String member_pass;
	String member_name;
	String member_email;
}







