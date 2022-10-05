<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="manage.*"%>
<% 
  	String n = request.getParameter("num");
  	int num = 0;
  	if(n == null){
  		response.sendRedirect("list.jsp");
  	}else{
  		num = Integer.parseInt(n);
  		MemberService memberService = new MemberService(new MemberDAO());
  		MemberVO vo = memberService.read(num);
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 페이지</title>
</head>
<body>
		<% if(vo == null){ %>
			회원정보가 존재하지 않습니다.
		<% }else {%>
			번호 : <%= vo.getNum() %><br>
			아이디 : <%= vo.getMemberId() %><br>
			닉네임 : <%= vo.getNickName() %><br>
			등록일 : <%= vo.getRegdate() %><br>
			<a href="modifyForm.jsp?num=<%= vo.getNum() %>"><button>수정</button></a>
			<a href="deleteForm.jsp?num=<%= vo.getNum() %>"><button>삭제</button></a>
		<% } %>
</body>
</html>
<% } %>