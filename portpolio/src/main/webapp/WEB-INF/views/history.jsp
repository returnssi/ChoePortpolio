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
    <!-- CSS 연결 -->
    <link rel="stylesheet" href="../resources/css/history.css"/>
    <link rel="stylesheet" href="../resources/css/ModalNotice.css">
    <link rel="stylesheet" href="../resources/css/reset.css"/>
    
    <!-- JS 연결 -->
    <script src="../resources/js/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="../resources/js/canvasjs.min.js"></script>
	<script type="text/javascript" src="../resources/js/jquery.canvasjs.min.js"></script>
	<script src="../resources/js/notice.js"></script>
    
</head>
<body>


	<%@ include file = "/WEB-INF/views/header.jsp" %>

	    <section id="mainContents"><!--#mainContents-->
		
		
        <div id="introText"><!--#introText-->
            저는 이런 경험을 해봤습니다!
        </div><!--#introText-->

        <div id="hContent"><!--#hContent-->
            <p id="title">1. 샘플샘플샘플</p>
            <img id="cImg" src="./resources/img/c01.jpg">
            <p id="content">
                샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다
                샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다
            </p>
        </div><!--#hContent-->

        <div id="hContent"><!--#hContent-->
            <p id="title">2. 샘플샘플샘플</p>
            <img id="cImg" src="./resources/img/c02.jpg">
            <p id="content">
                샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다
            </p>
        </div><!--#hContent-->

        <div id="hContent"><!--#hContent-->
            <p id="title">3. 샘플샘플샘플</p>
            <img id="cImg3" src="./resources/img/c03.jpg">
            <p id="content">
                국가적으로 샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다
            </p>
        </div><!--#hContent-->

        <div id="hContent"><!--#hContent-->
            <p id="title">4. 그 외 다양한 경험</p>
            <img id="cImg3" src="./resources/img/c04.jpg">
            <p id="content">
                샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다샘플입니다
            </p>
        </div><!--#hContent-->
		
		
		</section><!--#mainContents-->

	<%@ include file = "/WEB-INF/views/footer.jsp" %>

</body>
</html>