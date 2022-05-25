<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

<%@ include file = "/WEB-INF/views/header.jsp" %>

<form action="member/register">	

	<div>
		아이디 : <input type="text" name="m_id" placeholder="아이디를 입력하세요">
		<div class="check_font" id="check_font"></div>
	</div>
	<div>
		비밀번호 : <input type="text" name="m_password" placeholder="비밀번호를 입력하세요">
	</div>
	<div>
		이름 : <input type="text" name="m_name" placeholder="이름을 입력하세요">
	</div>
	<div>
		닉네임 : <input type="text" name="m_nickname" placeholder="닉네임을 입력하세요">
	</div>
	<div>
		휴대폰 번호 : <input type="text" name="m_phonnumber" placeholder="휴대폰 번호 입력하세요 예)01012345678">
	</div>
	<div>
		이메일 : <input type="text" name="m_email" placeholder="이메일 입력하세요 예)test@naver.com">
	</div>

</form>

	<%@ include file = "/WEB-INF/views/footer.jsp" %>

</body>
</html>