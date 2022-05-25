<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Choe's PortPolio</title>
	<!-- css 연결 -->	
	<link rel="stylesheet" href="../resources/css/noticeWrite.css">
	<link rel="stylesheet" href="../resources/css/ModalNotice.css">
	<link rel="stylesheet" href="../resources/css/summernote/summernote-lite.css">
	<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">
	<link rel="stylesheet" href="../resources/css/reset.css">
	
	<!--js 연결-->
	<script src="../resources/js/jquery-3.6.0.min.js"></script>
	<script src="../resources/js/noticeModify.js"></script>
	<script src="../resources/js/notice.js"></script>
	<script src="../resources/js/NoticeResult.js"></script>
	<script src="../resources/js/summernote/summernote-lite.js"></script>
	<script src="../resources/js/summernote/lang/summernote-ko-KR.js"></script>
	<script src="../resources/js/editor.js"></script>
</head>
<body>

	<%@ include file = "/WEB-INF/views/header.jsp" %>

    <section id="mainContents"><!--#mainContents-->
	<h2 id="boardSubject">공지사항</h2>
	<form role = "form" action="/notice/modify" method="post" onsubmit="return check()">
	<div id="notice_top">
	<input type="text" name="notice_title" id="notice_title" value="${modify.notice_title}" placeholder="제목을 입력하세요.">
	<input type="hidden" name="notice_wrnick" id="notice_wrnick" value="${modify.notice_wrnick}">
	<input type="hidden" name="notice_wrid" id="notice_wrid" value="${modify.notice_wrid}">
	<input type="hidden" name="notice_id" id="notice_id" value="${modify.notice_id}">
	
	</div>
	<div id = "notcieContents"><textarea class="yui3-cssreset" id="notice_content" name="notice_content" placeholder="내용을 입력하세요." cols="30" rows="10">${modify.notice_content}</textarea></div>
	<c:if test="${session.m_admin==1}">
	<div id = "notice_bottom">
		<input type="submit" id="uploadBtn" value="글쓰기">
	</div>
	</c:if>
	</form>
    </section><!--#mainContents-->

	<%@ include file = "/WEB-INF/views/footer.jsp" %>

</body>
</html>