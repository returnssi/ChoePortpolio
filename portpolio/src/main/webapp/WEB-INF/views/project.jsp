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
	<!--js연결-->
	<script src="../resources/js/jquery-3.6.0.min.js"></script>
	<script src="../resources/js/proejct.js"></script>
	<script src="../resources/js/notice.js"></script>
	
	<!--css 연결-->
	<link rel="stylesheet" href="../resources/css/project.css">
	<link rel="stylesheet" href="../resources/css/ModalNotice.css">
	<link rel="stylesheet" href="../resources/css/reset.css"/>
</head>
<body>

	<%@ include file = "/WEB-INF/views/header.jsp" %>

    <section id="mainContents"><!--#mainContents-->


        <div id="project"><!--#project-->
            <div id="projectImg"><!--#projectImg-->
                <img src="../resources/img/clientside.png" alt="클라이언트사이드">
            </div><!--#projectImg-->
            <div id="projectContent"><!--#projectContent-->
                <p id="p1">대학교 프로젝트</p>
                <p id="p2">클라이언트 사이드 (Client Side)</p>
                <p id="p3">샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다</p>
            </div><!--#projectContent-->
            <div id="downBtn">
                <form action="pdf" method="GET">
                    <button id="submit" name="pdfViewer" value="Clientside">보고서 보기</button>
                </form>
            </div>
        </div><!--#project-->

        <div id="project"><!--#project-->
            <div id="projectImg"><!--#projectImg-->
                <img src="../resources/img/cloud.png" alt="클라우드컴퓨팅">
            </div><!--#projectImg-->
            <div id="projectContent"><!--#projectContent-->
                <p id="p1">대학교 프로젝트</p>
                <p id="p2">클라우드 컴퓨팅 (Cloud Computing)</p>
                <p id="p3">샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다</p>
            </div><!--#projectContent-->
            <div id="downBtn">
            <form action="pdf" method="GET">
                <button id="submit" name="pdfViewer" value="cloudcomputing">보고서 보기</button>
            </form>
            </div>
        </div><!--#project-->

        <div id="project"><!--#project-->
            <div id="projectImg"><!--#projectImg-->
                <img src="../resources/img/datast.png" alt="데이터베이스설계">
            </div><!--#projectImg-->
            <div id="projectContent"><!--#projectContent-->
                <p id="p1">대학교 프로젝트</p>
                <p id="p2">데이터베이스 설계 (Database Design)</p>
                <p id="p3">샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다</p>
            </div><!--#projectContent-->
            <div id="downBtn">
            <form action="pdf" method="GET">
                <button id="submit" name="pdfViewer" value="Datastructure">보고서 보기</button>
            </form>
            </div>
        </div><!--#project-->

        <div id="project"><!--#project-->
            <div id="projectImg"><!--#projectImg-->
                <img src="../resources/img/java.png" alt="자바프로그래밍">
            </div><!--#projectImg-->
            <div id="projectContent"><!--#projectContent-->
                <p id="p1">대학교 프로젝트</p>
                <p id="p2">자바 프로그래밍 (JAVA)</p>
                <p id="p3">샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다</p>
            </div><!--#projectContent-->
            <div id="downBtn">
            <form action="pdf" method="GET">
                <button id="submit" name="pdfViewer" value="java">보고서 보기</button>
            </form>
            </div>
        </div><!--#project-->

        <div id="project"><!--#project-->
            <div id="projectImg"><!--#projectImg-->
                <img src="../resources/img/MobileApp.png" alt="모바일앱개발">
            </div><!--#projectImg-->
            <div id="projectContent"><!--#projectContent-->
                <p id="p1">대학교 프로젝트</p>
                <p id="p2">모바일앱개발 (Mobile App DEV)</p>
                <p id="p3">샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다</p>
            </div><!--#projectContent-->
            <div id="downBtn">
            <form action="pdf" method="GET">
                <button id="submit" name="pdfViewer" value="MobileAppDEV">보고서 보기</button>
            </form>
            </div> 
        </div><!--#project-->

        <div id="project"><!--#project-->
            <div id="projectImg"><!--#projectImg-->
                <img src="../resources/img/serverside.png" alt="서버사이드프로그래밍">
            </div><!--#projectImg-->
            <div id="projectContent"><!--#projectContent-->
                <p id="p1">대학교 프로젝트</p>
                <p id="p2">서버 사이드 프로그래밍 (Server Side Programming)</p>
                <p id="p3">샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다</p>
            </div><!--#projectContent-->
            <div id="downBtn">
            <form action="pdf" method="GET">
                <button id="submit" name="pdfViewer" value="serverside">보고서 보기</button>
            </form>
            </div>
        </div><!--#project-->

        <div id="project"><!--#project-->
            <div id="projectImg"><!--#projectImg-->
                <img src="../resources/img/system.png" alt="시스템분석및설계">
            </div><!--#projectImg-->
            <div id="projectContent"><!--#projectContent-->
                <p id="p1">대학교 프로젝트</p>
                <p id="p2">시스템 분석 및 설계 (System Analysis and Design)</p>
                <p id="p3">샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다</p>
            </div><!--#projectContent-->
            <div id="downBtn">
            <form action="pdf" method="GET">
                <button id="submit" name="pdfViewer" value="system">보고서 보기</button>
            </form>
            </div>
        </div><!--#project-->
       
    </section><!--#mainContents-->

	<%@ include file = "/WEB-INF/views/footer.jsp" %>

</body>
</html>