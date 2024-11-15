package com.firstzone.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class MemberDTO {
	String member_id;
	String member_pass;
	String member_name;
	String member_email;
}
