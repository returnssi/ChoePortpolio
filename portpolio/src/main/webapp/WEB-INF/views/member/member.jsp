<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Choe's PortPolio</title>
    <!--css 관련-->
    <link rel="stylesheet" href="../resources/css/member.css">
    <link rel="stylesheet" href="../resources/css/ModalNotice.css">
    <link rel="stylesheet" href="../resources/css/reset.css">
    
    <!--js 관련-->
    <script src="../resources/js/jquery-3.6.0.min.js"></script>
    <script src="../resources/js/jquery-migrate-1.4.1.min.js"></script>
    <script type="text/javascript" src="/resources/js/Register.js"></script>
    <script type="text/javascript" src="/resources/js/notice.js"></script>
    
</head>
<body>
	
	<%@ include file = "/WEB-INF/views/header.jsp" %>
	
    <section id="mainContents"><!--#mainContents-->

	<form action="memberWrite" method="post" id="memberRegister" onsubmit="return check()">

	<h2 id="regTitle">회원가입</h2>
	<p id="regContent">저희 사이트를 가입하시는 것을 감사합니다. 아래의 양식을 입력하시고 가입버튼을 누르시면 회원가입이 완료됩니다!</p>

	<div class="textForm idCheck">
		<input type="text" class="m_id" name="m_id" id="m_id" placeholder="아이디를 입력하세요">
			<div id="resultId"></div>
		<button id="idck" type="button">중복확인</button>
	</div>
	
	<div class="textForm">
		<input type="password" name="m_password" id="m_password" placeholder="비밀번호를 입력하세요">
	</div>
	
	<div class="textForm">
		<input type="password" name="m_password2" id="m_password2" placeholder="비밀번호를 입력하세요">
	</div>

	<div class="textForm">
		<input type="text" name="m_name" id="m_name" placeholder="이름을 입력하세요">
	</div>

	<div class="textForm">
		<input type="text" name="m_nickname" id="m_nickname" placeholder="닉네임을 입력하세요">
	</div>
	
	<div class="textForm">
		<input type="text" name="m_phonnumber" id="m_phonnumber" placeholder="휴대폰 번호 입력하세요 예)01012345678">
	</div>
	
	<div class="textForm">
		<input type="text" id="m_email" name="m_email" placeholder="이메일 입력하세요">
	</div>

	<input id="submit" type="submit" value="가입">
	</form>

	</section><!--#mainContents-->

	<%@ include file = "/WEB-INF/views/footer.jsp" %>
</body>
</html>