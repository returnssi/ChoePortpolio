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
	<!--css 연결-->
	<link rel="stylesheet" href="../resources/css/404.css">
	<link rel="stylesheet" href="../resources/css/reset.css"/>
	
	<!--js 연결-->
    <script src="../resources/js/jquery-3.6.0.min.js"></script>
    <script src="../resources/js/jquery-migrate-1.4.1.min.js"></script>
	<script src="../resources/js/404.js"></script>
	<script src="../resources/js/notice.js"></script>
</head>
<body>

	<%@ include file = "/WEB-INF/views/header.jsp" %>

    <div id="mainContents"><!--#mainContents-->


        <div class="bg">
            <video muted autoplay loop>
              <source src="../resources/img/404.mp4" type="video/mp4">
            </video>
            <div class="text">
                <p id="main">OOPS! 503</p>
                <p id="info">오류가 발생했어요! <br><br><br><br><br><br><br><br><br><br><br></p>
                <p id="info1">혹시 잘못 누르셨나요? 그게 아니라면 사이트 관리자에게 문의해주세요 :D</p>
                <p id="info3"><input type="button" value="돌아가기" onclick="history.back(-1);"><button id="myBtn1">문의하기</button></p>
            </div>
          </div>

	              <!-- 문의모달 -->
	        <div id="myModal1" class="modal">
	    
	            <!-- 문의모달 내용 -->
	            <div class="modal-content">
	                <span class="close1">&times;</span>                                                               
	                <p>이메일 문의는 helpodinbox@gmail.com로 문의주세요!</p>
	            </div>
            </div>

    </div><!--#mainContents-->

	<%@ include file = "/WEB-INF/views/footer.jsp" %>

</body>
</html>