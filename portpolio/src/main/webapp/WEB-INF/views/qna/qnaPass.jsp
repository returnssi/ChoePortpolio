<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 비밀번호 입력</title>
</head>
<body>
	<div id="passwordDiv">
		<p>글에 설정하신 비밀번호를 입력해주세요.</p>
		<form action="/qna/detail">
			<input type="text" name="qna_id" id="qna_id" value="${qdetail.qna_id}">
			<input type="password" name="qna_pass" id="qna_pass">
			<input type="submit" id="view" value="글 보기">
		</form>
	</div>
</body>
</html>