<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Choe's PortPolio</title>
</head>

	<!--css 관련-->
    <link rel="stylesheet" href="../resources/css/admin.css">
    <link rel="stylesheet" href="../resources/css/ModalNotice.css">
    <link rel="stylesheet" href="../resources/css/reset.css">
    
    <!--  js 관련 -->
    <script src="../resources/js/jquery-3.6.0.min.js"></script>
    <script src="../resources/js/jquery-migrate-1.4.1.min.js"></script>


<body>
		<%@ include file = "/WEB-INF/views/header.jsp" %>
		    <section id="mainContents"><!--#mainContents-->
				<c:if test="${session.m_admin==0}">
					<p>관리자만 접근 할 수 있는 페이지입니다.</p>
				</c:if>
				<c:if test="${session.m_admin==1}">
						<a target='_self' href="/notice/write"><img class="noticeWrite" src="../resources/img/noticeWrite.png" alt="공지사항 글 쓰기"></a>
				</c:if>
		
			</section><!--#mainContents-->
		<%@ include file = "/WEB-INF/views/footer.jsp" %>
</body>
</html>