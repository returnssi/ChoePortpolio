<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 헤더영역 시작 -->

    <header id="header"><!--#header-->
        <div id="headerIn"><!--#headerIn-->
            <a href="/main"><img id="bLogo" src="../resources/img/logo.png" alt="로고"></a>
            <ul class="nav"><!--.nav-->
                <li><a href="/history">HISTORY</a></li>
                <li><a href="/aboutme">ABOUTME</a></li>
                <li><a href="/project">PROJECT</a></li>
                <li><a href="/qna">BOARD</a></li>
                <c:if test="${session.m_id==null}">
                <li><a href="/member/login">LOGIN</a></li>
                </c:if>
            </ul><!--.nav-->
            <div id="notice"><!--#notice-->
            <c:forEach items="${nlist}" var="notice" end="0">
                <p id="noticeContent"><button id="myBtn">${notice.notice_title}</button></p>
             </c:forEach>
            </div><!--#notice-->
        </div><!--#headerIn-->
        <div class="bar"><!--.bar-->
            <span>혁신을 이룹니다. &nbsp;</span>
            <span>혁신적인 개발자 &nbsp;</span>
            <span>최영환 포트폴리오 &nbsp;</span>
            <span>조직의 문화에 친화적인 &nbsp;</span>
            <span>개발자로 되겠습니다 &nbsp;</span>
        </div><!--.bar-->
    </header><!--#header-->
    
       <div id="pointer"><!--#pointer-->
        <a href="#">
        <img src="../resources/img/up-arrow.png" alt="상단으로">
        </a>
    </div><!--#pointer-->
<!-- 헤더영역 끝 -->