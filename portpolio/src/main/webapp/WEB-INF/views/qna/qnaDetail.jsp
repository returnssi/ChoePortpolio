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

    <!-- CSS 관련-->
    <link rel="stylesheet" href="../resources/css/notice.css">
    <link rel="stylesheet" href="../resources/css/ModalNotice.css">
    <link rel="stylesheet" href="../resources/css/reset.css">
    
    <!-- JS 관련-->
    <script src="../resources/js/jquery-3.6.0.min.js"></script>
    <script src="../resources/js/jquery-migrate-1.4.1.min.js"></script>
    <script src="../resources/js/bootstrap.js"></script>
    <script src="../resources/js/notice.js"></script>
    <script src="../resources/js/attachResult.js"></script>
    <script src="../resources/js/reply.js"></script>
    <script src="../resources/js/replyCheck.js"></script>
</head>
<body>
	
	<%@ include file = "/WEB-INF/views/header.jsp" %>
	
    <section id="mainContents"><!--#mainContents-->

		<div id="no_title">
			${qdetail.qna_title}
		</div>
		<div id="no_content">
		<c:choose>
		<c:when test="${qdetail.qna_wrid == session.m_id || session.m_admin == '1'}">
			<input type="hidden" id ="qna_id" value="${qdetail.qna_id}">
			${qdetail.qna_content}
		<div id="uploadResult">
			<ul>
							
			</ul>
		</div>
		</c:when>
		<c:when test="${qdetail.qna_wrid != session.m_id || m_admin == '0'}">
			<div id="backDiv">
				<p id='back'>작성자가 아니거나 관리자가 아니면 해당 글을 보실 수 없습니다! 로그인 후 이용해주세요!</p>
				<button id="back1" onclick="history.back(-1);">돌아가기</button>
			</div>
		</c:when>
		</c:choose>
		</div>
		
		<c:if test="${qdetail.qna_wrid == session.m_id || session.m_admin == '1'}">
    	<ul class = "replyList" id="replyList">
                            
        </ul>
        
			<div id="replyForm">
		        	<p>댓글쓰기</p>
			        	<form onsubmit="return check()">
				        	<textarea id="qreply_comment" placeholder="댓글내용을 입력하세요" rows="4" style="width:100%;"></textarea>
					        <input id = "qreply_nickname" class="form-control" type="text" value="${session.m_nickname}" readonly>
					        <input id = "qreply_wrid" class="form-control" type="hidden" readonly value="${session.m_id}">
					        <input id = "qna_id" class="form-control" type="hidden"  value="${qdetail.qna_id}" readonly>
					        <input id = "qreply_no" class="form-control" type="hidden" readonly>
				        	<button type="submit" id = "replyWriteBtn">댓글 쓰기</button>
				        	<button type="submit" id = "replymodBtn">댓글 수정</button>
				        <c:if test="${qreply_wrid == session.m_id}">
				        	<button type="button" id = "replydelBtn">댓글 삭제</button>
				        </c:if>
				        </form>
	        </div>
        <!-- 댓글 끝 -->
        </c:if>
        
		<div id="btnNotice">
		
		<c:if test="${qdetail.qna_wrid == session.m_id || session.m_admin == '1'}">
		<a href="/qna/modify?qna_id=${qdetail.qna_id}">수정</a>
		<a href="/qna/remove?qna_id=${qdetail.qna_id}">삭제</a>

		<button onclick="history.back(-1);">돌아가기</button>
		</c:if>
		</div>
                            
    </section><!--#mainContents-->

	<%@ include file = "/WEB-INF/views/footer.jsp" %>

</body>
</html>