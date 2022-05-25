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
	<!--css 연결-->
	<link rel="stylesheet" href="../resources/css/reset.css">
	<link rel="stylesheet" href="../resources/css/boardDetail.css">
	<link rel="stylesheet" href="../resources/css/ModalNotice.css">
	
	<!--js 연결-->
	<script src="../resources/js/jquery-3.6.0.min.js"></script>
	<script src="../resources/js/jquery-migrate-1.4.1.min.js"></script>
	<script src="../resources/js/notice.js"></script>
	<script src="../resources/js/noticeResult.js"></script>
	<script type="text/javascript" src="../resources/js/list.js"></script>
</head>
<body>

	<%@ include file = "/WEB-INF/views/header.jsp" %>

    <section id="mainContents"><!--#mainContents-->

	<h2>검색된 게시글 수는 ${PageMaker.total}개입니다.</h2>
    <table class="boardList">
        <caption>게시글 목록</caption>

        <colgroup>
            <col style="width:7%;">
            <col style="width:auto;">
            <col style="width:15%;">
            <col style="width:11%;">
            <col style="width:6%;">
        </colgroup>

        <thead>
            <tr>
                <th scope="col">No</th>
                <th scope="col">제목</th>
                <th scope="col">작성일</th>
                <th scope="col">이름</th>
            </tr>
        </thead>

        <tbody>

            <c:forEach items="${qlist}" var="qna">
                <tr>
                    <td class="bNo">${qna.qna_id}</td>
                    
                    
                    <c:choose>
					  <c:when test="${qna.qna_wrid != session.m_id}">
					 	 <td class="bTl">[비밀(작성자 및 관리자만 볼 수 있습니다))] ${qna.qna_title}</td>
					  </c:when>
					  <c:when test="${qna.qna_wrid == session.m_id}">
					 	 <td class="bTl"><a href="./qna/detail?qna_id=${qna.qna_id}">${qna.qna_title}</a></td>
					  </c:when>
<%-- 					  <c:when test="${session.m_admin == '1' && qna.qna_wrid != session.m_id}"> --%>
<%-- 					  	<td class="bTl"><a href="./qna/detail?qna_id=${qna.qna_id}">${qna.qna_title}</a></td> --%>
<%-- 					  </c:when> --%>
					 </c:choose>
					 
					 
					 <c:if test="${session.m_admin=='1'}">
					 	<td class="bTl"><a href="./qna/detail?qna_id=${qna.qna_id}">${qna.qna_title}</a></td>
					 </c:if>
					 
                    
                    <td class="bDt">${qna.qna_date}</td>
                    <td class="bNm">${qna.qna_wrnick}</td>
                </tr>
            </c:forEach>

        </tbody>

    </table>


	<c:if test="${session.m_admin==1}">
		<a href="/qna/write">글쓰기</a>
	</c:if>
	<form action="/qna" id="searchForm">
	<select name="type" id="type">
		<option value="">검색구분</option>
		<option value="t" ${PageMaker.cri.type eq 't'?'selected':''}>제목</option>
		<option value="w" ${PageMaker.cri.type eq 'w'?'selected':''}>작성자</option>
		<option value="tw" ${PageMaker.cri.type eq 'tw'?'selected':''}>제목+글작성자</option>
	</select>
	<input type="text" name="keyword" id="keyword" value="${PageMaker.cri.keyword}" placeholder="검색어">
	<input type="submit" value="검색" id="searchbtn">
	
	<input type="hidden" id="pagenum" name="pagenum" value="${PageMaker.cri.pagenum}">
	<input type="hidden" id="amount" name="amount" value="${PageMaker.cri.amount}">
	
	<div id="pagingNo">
			<c:if test="${PageMaker.prev}">
			<a href="/qna?pagenum=${PageMaker.startPage-1}&amount=${PageMaker.cri.amount}">PREV</a>
			</c:if>
			<c:forEach var="num" begin="${PageMaker.startPage}" end="${PageMaker.endPage}">
				<a class = "pageNo" href="${num}">${num}</a>
			</c:forEach>
			<c:if test="${PageMaker.next}">
			<a href="/qna?pagenum=${PageMaker.endPage+1}&amount=${PageMaker.cri.amount}">NEXT</a>
			</c:if>
		</div>
	</form>
	
    </section><!--#mainContents-->

	<%@ include file = "/WEB-INF/views/footer.jsp" %>

</body>
</html>