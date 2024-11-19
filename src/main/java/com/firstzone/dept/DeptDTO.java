package com.firstzone.dept;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//class이름은 대문자시작
//변수이름, 함수이름은 소문자시작 
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter 
public class DeptDTO {
	int department_id  ;   
	String department_name ;  
	int manager_id  ;      
	int location_id  ;     
}

















