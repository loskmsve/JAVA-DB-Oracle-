<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="manage.*, java.util.List"%>
    <%
    	MemberService ms = new MemberService(new MemberDAO());
    	List<MemberVO> ls = ms.listAll();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록보기 페이지</title>
</head>
<body>
<h3>회원 목록</h3>
<table border="1">
<% if(ls.size() == 0) {%>
	<tr><td>목록이 없습니다.</td></tr>
<% } else {%>
	<tr><th>번호</th><th>아이디</th><th>닉네임</th></tr>
	<% for(MemberVO vo : ls) { %>
	<tr>
		<td><%= vo.getNum() %></td>
		<td><a href="detail.jsp?num=<%= vo.getNum() %>"><%= vo.getMemberId() %></a></td>
		<td><%= vo.getNickName() %></td>
	</tr>
	<% }  
	} 
%>
</table>

</body>
</html>