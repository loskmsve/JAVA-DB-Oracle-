<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="manage.*"%>
<%
	request.setCharacterEncoding("utf-8");
	
	int num = Integer.parseInt(request.getParameter("num"));
	String memberId = request.getParameter("memberId");
	String memberPwOld = request.getParameter("memberPwOld");
	String memberPwNew = request.getParameter("memberPwNew");
	String nickName = request.getParameter("nickName");
	
	MemberService memberService = new MemberService(new MemberDAO());
	MemberVO vo = new MemberVO(num, memberId, memberPwNew, nickName);
	
	if(memberService.edit(vo, memberPwOld)){
		response.sendRedirect(request.getContextPath() + "/member/detail.jsp?num=" + num);
	}else {
		response.sendRedirect(request.getContextPath() + "/member/modifyForm.jsp?num=" + num);
	}
%>