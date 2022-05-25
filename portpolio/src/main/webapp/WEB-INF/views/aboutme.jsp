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
	<!--css 관련-->
	<link rel="stylesheet" href="../resources/css/aboutme.css">
	<link rel="stylesheet" href="../resources/css/ModalNotice.css">
	<link rel="stylesheet" href="../resources/css/reset.css">
	
	<!-- js 연결-->
	<script src="../resources/js/jquery-3.6.0.min.js"></script>
	<script src="../resources/js/notice.js"></script>
</head>
<body>
	
	<%@ include file = "/WEB-INF/views/header.jsp" %>

    <section id="mainContents"><!--#mainContents-->


        <div id="history"><!--#history-->
            <div id="historyImg"><!--#historyImg-->
                <img src="../resources/img/c04.jpg" alt="SampleSample">
            </div><!--#historyImg-->
            <div id="historyContent"><!--#historyContent-->
                <p id="p1">2010. 12</p>
                <p id="p2">SampleSampleSampleSampleSampleSampleSampleSample</p>
                <p id="p3">SampleSampleSampleSampleSampleSampleSampleSampleSampleSampleSampleSampleSampleSample</p>
            </div><!--#historyContent-->
        </div><!--#history-->

        <div id="history"><!--#history-->
            <div id="historyImg"><!--#historyImg-->
                <img src="../resources/img/c04.jpg" alt="SampleSample">
            </div><!--#historyImg-->
            <div id="historyContent"><!--#historyContent-->
                <p id="p1">2014. 03</p>
                <p id="p2">[학교] SampleSampleSampleSampleSampleSampleSampleSample</p>
                <p id="p3">SampleSampleSampleSampleSampleSampleSampleSampleSampleSample </p>
            </div><!--#historyContent-->
        </div><!--#history-->
        
        <div id="history"><!--#history-->
            <div id="historyImg"><!--#historyImg-->
                <img src="../resources/img/c04.jpg" alt="SampleSampleSampleSampleSampleSample">
            </div><!--#historyImg-->
            <div id="historyContent"><!--#historyContent-->
                <p id="p1">2019. 12</p>
                <p id="p2">[학교] SampleSampleSampleSampleSampleSampleSampleSample</p>
                <p id="p3">SampleSampleSampleSampleSampleSampleSampleSampleSampleSample</p>
            </div><!--#historyContent-->
        </div><!--#history-->

        <div id="history"><!--#history-->
            <div id="historyImg"><!--#historyImg-->
                <img src="../resources/img/c04.jpg" alt="SampleSampleSampleSampleSampleSample">
            </div><!--#historyImg-->
            <div id="historyContent"><!--#historyContent-->
                <p id="p1">2020. 03 - 12</p>
                <p id="p2">SampleSampleSampleSampleSampleSampleSampleSampleSampleSample</p>
                <p id="p3">SampleSampleSampleSampleSampleSampleSampleSampleSampleSampleSampleSample</p>
            </div><!--#historyContent-->
        </div><!--#history-->

        <div id="history"><!--#history-->
            <div id="historyImg"><!--#historyImg-->
                <img src="../resources/img/c04.jpg" alt="SampleSampleSampleSampleSampleSample">
            </div><!--#historyImg-->
            <div id="historyContent"><!--#historyContent-->
                <p id="p1">2020. 06</p>
                <p id="p2">SampleSampleSampleSampleSampleSampleSampleSample</p>
                <p id="p3">SampleSampleSampleSampleSampleSampleSampleSampleSampleSampleSampleSampleSampleSample</p>
            </div><!--#historyContent-->
        </div><!--#history-->

        <div id="history"><!--#history-->
            <div id="historyImg"><!--#historyImg-->
                <img src="../resources/img/c04.jpg" alt="SampleSampleSampleSampleSampleSample">
            </div><!--#historyImg-->
            <div id="historyContent"><!--#historyContent-->
                <p id="p1">2021. 02</p>
                <p id="p2">SampleSampleSampleSampleSampleSampleSampleSampleSampleSample</p>
                <p id="p3">SampleSampleSampleSampleSampleSampleSampleSampleSampleSampleSampleSampleSampleSample</p>
            </div><!--#historyContent-->
        </div><!--#history-->

        <div id="history"><!--#history-->
            <div id="historyImg"><!--#historyImg-->
                <img src="../resources/img/c04.jpg" alt="SampleSampleSampleSampleSampleSampleSampleSample">
            </div><!--#historyImg-->
            <div id="historyContent"><!--#historyContent-->
                <p id="p1">2021. 03 - 현재진행중</p>
                <p id="p2">SampleSampleSampleSampleSampleSampleSampleSample</p>
                <p id="p3">SampleSampleSampleSampleSampleSampleSampleSampleSampleSampleSampleSampleSampleSample</p>
            </div><!--#historyContent-->
        </div><!--#history-->

    </section><!--#mainContents-->

	<%@ include file = "/WEB-INF/views/footer.jsp" %>

</body>
</html>