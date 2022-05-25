<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Choe's PortPolio</title>
    <!--css 관련-->
    <link rel="stylesheet" href="../resources/css/login.css">
    <link rel="stylesheet" href="../resources/css/ModalNotice.css">
    <link rel="stylesheet" href="../resources/css/reset.css">
    
    <!--js 연결-->
    <script src="../resources/js/jquery-3.6.0.min.js"></script>
    <script src="../resources/js/jquery-migrate-1.4.1.min.js"></script>
    <script src="../resources/js/loginChecking.js"></script>
    <script src="../resources/js/notice.js"></script>
</head>
<body>

	<%@ include file = "/WEB-INF/views/header.jsp" %>
	
    <section id="mainContents"><!--#mainContents-->
    
    <div class="loginForm">
		<form action="/admin/login" method="post">
			<h1>관리자 로그인</h1>
		<div>
			<img alt="아이디" src="../resources/img/id.png">
			<input type="text" id="m_id" name="m_id" placeholder="ID">
		</div>
		<div>
			<img alt="비밀번호" src="../resources/img/password.png">
			<input type="password" id="m_password" name="m_password" placeholder="PASSWORD">
		</div>
		<div>
			<button id = "btnLogin" type="submit" value="로그인">로그인</button>
			<div id="errMsg">${errMsg}</div>
		</div>
		
		</form>
	</div>

    </section><!--#mainContents-->

	<%@ include file = "/WEB-INF/views/footer.jsp" %>

</body>
</html>