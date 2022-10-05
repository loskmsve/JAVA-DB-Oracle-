<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="manage.*"%>
<%
	request.setCharacterEncoding("utf-8");
	
	String memberId = request.getParameter("memberId");
	String memberPw = request.getParameter("memberPw");
	String nickName = request.getParameter("nickName");
	
	MemberVO vo = new MemberVO(-1, memberId, memberPw, nickName);
	MemberDAO dao = new MemberDAO();
	MemberService memberService = new MemberService(dao);
	
	if(memberService.regist(vo)){
		response.sendRedirect(request.getContextPath()+"/member/index.jsp");
	}else{
		response.sendRedirect(request.getContextPath()+"/member/registForm.jsp");
	}
%>