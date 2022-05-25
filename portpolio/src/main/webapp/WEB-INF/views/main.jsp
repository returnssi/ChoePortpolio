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
	<!-- js 연결 -->
	<script src="../resources/js/jquery-3.6.0.min.js"></script>
	<script src="../resources/js/jquery-migrate-1.4.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.js"></script>
	<script src="../resources/js/main.js"></script>
	<script src="../resources/js/notice.js"></script>
	
	
	<!-- css 연결 -->
	<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick-theme.css">
	<link rel="stylesheet" href="../resources/css/main.css">
	<link rel="stylesheet" href="../resources/css/ModalNotice.css">
	<link rel="stylesheet" href="../resources/css/reset.css">
</head>
<body>
	
	<%@ include file = "/WEB-INF/views/header.jsp" %>

    <section id="mainContents"><!--#mainContents-->
        
        <c:if test="${session!=null}">
        	<p class="login">${session.m_nickname} 님 반갑습니다! <a href="/member/logout">로그아웃</a></p>
        </c:if>
        
        <div class="slick-sample"><!--.slick-sample-->
            <div><img src="../resources/img/sample.jpg" alt=""></div>
            <div><img src="../resources/img/sample2.jpg" alt=""></div> 
            <div><img src="../resources/img/sample3.jpg" alt=""></div>
        </div><!--.slick-sample-->

        <div id="helloChoe"><!--#helloChoe-->
            <div id="choeMain1" onclick="location.href='/history';">
                <p id="bTitle">History</p>
                <p id="sContent">제가 경험하고 걸어온 길은 이렇습니다!</p>
            </div><!--#choeMain1-->

            <div id="choeMain2" onclick="location.href='/aboutme';">
                <p id="bTitle">About ME</p>
                <p id="sContent">저의 간단한 이력을 말씀드릴께요!</p>
            </div><!--#choeMain2-->

            <div id="choeMain3" onclick="location.href='/project';">
                <p id="bTitle">Project</p>
                <p id="sContent">제가 해봤던 경험입니다!</p>
            </div><!--#choeMain3-->

            <div id="choeMain4" onclick="location.href='/qna';">
                <p id="bTitle">Board</p>
                <p id="sContent">저에게 궁금하신 점이 또 있으신가요?</p>
            </div><!--#choeMain4-->
        </div><!--#helloChoe-->

    </section><!--#mainContents-->


    <%@ include file = "/WEB-INF/views/footer.jsp" %>

</body>
</html>