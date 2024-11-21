<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.firstzone.emp.EmpDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.firstzone.emp.EmpService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	EmpService eService = new EmpService();
	List<EmpDTO> emplist = eService.selectAllService();
	pageContext.setAttribute("empDatas", emplist);
	
	Map<String, List<EmpDTO>> map = new HashMap<>();
	map.put("empMap", emplist);
	pageContext.setAttribute("mymap", map);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
1. 스크립트릿 : <%=emplist.get(0).getFirst_name() %><br>
2. EL(list) : ${empDatas[0].first_name}
3. EL(map) : ${mymap["empMap"][0].first_name}
3. EL(map) : ${mymap["empMap"][1].first_name}

</body>
</html>