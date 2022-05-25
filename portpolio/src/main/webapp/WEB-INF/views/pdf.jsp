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
	<!--CSS 연결-->
	<link rel="stylesheet" href="../resources/css/pdf.css">
	<link rel="stylesheet" href="../resources/css/ModalNotice.css">
	<link rel="stylesheet" href="../resources/css/reset.css"/>
	
	<!--JS 연결-->
	<script src="../resources/js/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="../resources/js/canvasjs.min.js"></script>
	<script type="text/javascript" src="../resources/js/jquery.canvasjs.min.js"></script>
	<script src="../resources/js/notice.js"></script>

</head>
<body>

	<%@ include file = "/WEB-INF/views/header.jsp" %>

    <section id="mainContents"><!--#mainContents-->

            <div id="paper">
                <p id="pt">보고서 : <span id="filePath"></span></p>
                <div>
                    <button id="prev">이전</button>
                    <button id="next">다음</button>
                    <br>
                    <span id="pg">Page: <span id="page_num"></span> / <span id="page_count"></span></span>
                </div>

                <canvas id="the-canvas"></canvas>
                <br>
                <p id="introPdf">- 소중한 자료입니다 해당 자료는 외부로 유출을 금지하고 있습니다.</p>
            </div>

    </section><!--#mainContents-->
    
	<script src="//mozilla.github.io/pdf.js/build/pdf.js"></script>
	<script src="../resources/js/pdf.js"></script>
	
	<%@ include file = "/WEB-INF/views/footer.jsp" %>

</body>
</html>