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
    <link rel="stylesheet" href="../resources/css/notice.css">
    <link rel="stylesheet" href="../resources/css/ModalNotice.css">
    <link rel="stylesheet" href="../resources/css/reset.css">
    
    <!--Slick,jQuery 관련-->
    <script src="../resources/js/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
    <script src="../resources/js/jquery-migrate-1.4.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick-theme.css">
    
    <!--js 연결-->
    <script src="../resources/js/main.js"></script>
    <script src="../resources/js/notice.js"></script>
</head>
<body>
	
	<%@ include file = "/WEB-INF/views/header.jsp" %>
	
    <section id="mainContents"><!--#mainContents-->

		<div id="no_title">
			${ndetail.notice_title}
		</div>
		<div id="no_content">
			${ndetail.notice_content}
		</div>
		<div id="btnNotice">
		
		<c:if test="${session.m_admin==1}">
		<a href="/notice/modify?notice_id=${ndetail.notice_id}">수정</a>
		<a href="/notice/remove?notice_id=${ndetail.notice_id}">삭제</a>
		</c:if>
		
		<button onclick="history.back(-1);">돌아가기</button>
		</div>
		
		              <!-- 모달 -->
            <div id="myModal" class="modal">
    
	            <!-- 모달 컨텐츠 -->
	            <div class="modal-content">
	                <span class="close">&times;</span>                                                               
	                            <c:forEach items="${nlist}" var="notice" end="0">
                				<p id="nt-title">${notice.notice_title}</p>
                				<p id="nt-content">${notice.notice_content}</p>
             					</c:forEach>
	            </div>
    
            </div>
		
                            
    </section><!--#mainContents-->

	<%@ include file = "/WEB-INF/views/footer.jsp" %>

</body>
</html>