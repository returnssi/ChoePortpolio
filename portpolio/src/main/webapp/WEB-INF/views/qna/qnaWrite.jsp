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
	<!-- css 연결 -->	
	<link rel="stylesheet" href="../resources/css/qnaWrite.css">
	<link rel="stylesheet" href="../resources/css/ModalNotice.css">
	<link rel="stylesheet" href="../resources/css/reset.css">
	
	<!--js 연결-->
	<script src="../resources/js/jquery-3.6.0.min.js"></script>
	<script src="../resources/js/qnaWrite.js"></script>
	<script src="../resources/js/notice.js"></script>
	<script src="../resources/js/NoticeResult.js"></script>
	<script src="../resources/js/uploadAjax.js"></script>
</head>
<body>

	<%@ include file = "/WEB-INF/views/header.jsp" %>

    <section id="mainContents"><!--#mainContents-->
	<h2 id="boardSubject">QnA</h2>
	<c:if test="${session.m_id != null}">
	<div id="writeForm">
	<form role = "form" action="/qna/write" method="post" enctype="multipart/form-data" onsubmit="return check()">
	<input type="text" name="qna_title" id="qna_title" placeholder="제목을 입력하세요.">
	<input type="hidden" name="qna_wrnick" id="qna_wrnick" value="${session.m_nickname}">
	<input type="hidden" name="qna_wrid" id="qna_wrid" value="${session.m_id}">
	<div><textarea id="qna_content" name="qna_content" placeholder="내용을 입력하세요." cols="30" rows="10"></textarea></div>
	<div>
		<input type="file" name="uploadFile" multiple="multiple">
	</div>
	<input type="button" id="uploadBtn" value="글쓰기">
	<div id="uploadResult">
		<ul>
		
		</ul>
	</div>
	</form>
	</div>
	</c:if>
    </section><!--#mainContents-->

	<%@ include file = "/WEB-INF/views/footer.jsp" %>

</body>
</html>