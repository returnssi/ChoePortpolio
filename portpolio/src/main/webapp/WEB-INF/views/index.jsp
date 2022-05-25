<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dev Choe's Portfolio</title>
    <!--jQuery 연결 -->
    <script src="../resources/js/jquery-3.6.0.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script src="https://unpkg.com/typewriter-effect@2.3.1/dist/core.js"></script>
    <link rel="stylesheet" href="./resources/css/index.css">
    <script src="./resources/js/index.js"></script>
</head>
    <body>
    <audio autoplay loop>
        <source src="./resources/audio/Alan Walker - Unity (Extended Version) by Albert Vishi.mp3" type="audio/mpeg">
        <p>Your browser doesn't support HTML5 audio. Here is
           a <a href="./resources/audio/Alan Walker - Unity (Extended Version) by Albert Vishi.mp3">link to the audio</a> instead.</p>
     </audio>
     
        <div class="maintitle">
            <h1>최영환 포트폴리오</h1>
        </div><!--.maintitle-->
        <!-- 타이핑 시작 -->
        <div id="main">
            <div id="typeStyle"></div>
        </div><!--#main-->
        <!-- 타이핑 끝 -->
        <div id="btnDiv">
            <button id="show" onclick="div_show();"><a href="/main">보러가기</a></button>
            <div id="smalltitle">
                10초 후 이동 할 수 있는 버튼이 나옵니다.
            </div><!--smalltitle-->
        </div><!--#btnDiv-->
        
        <div id="copyright">
            Copyright ⓒ 최영환(member@tistory.com)
        </div><!--#copyright-->
    </body>
</html>