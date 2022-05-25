<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 푸터영역 시작 / 공지사항 모달 -->
              <!-- 모달 -->
            <div id="myModal" class="modal">
    
	            <!-- 모달 컨텐츠 -->
	            <div class="modal-content">
	                <span class="close">&times;</span>                                                               
	                            <c:forEach items="${nlist}" var="notice" end="0">
                				<p id="nt-title">${notice.notice_title}</p>
                				<p id="nt-content">${notice.notice_content}</p>
             					</c:forEach>
	            </div>
            </div>

    <footer id="footer"><!--#footer-->
        <div class="container"><!--.container-->
            <div class="row"><!--.row-->
                <div class="footer"><!--.footer-->
                    <p class="footer_p1">본 사이트는 IE, Edge를 지원하지 않습니다.</p>
                    <p class="footer_p2">"묵묵히 나의 길을 갈 수 있는 것도 용기"</p>
                    <div id="footerContent"><!--#footerContent-->
                                <a target='_blank' href="#"><img class="FootericoImg" src="../resources/img/git-hub.png" alt="GitHub"></a>
                                <a target='_blank' href="https://odinbox.co.kr/"><img class="FootericoImg" src="../resources/img/blog.png" alt="OdinBOX Web"></a>
                                <a target='_blank' href="https://www.youtube.com/user/wonderfulodinbox"><img class="FootericoImg" src="../resources/img/youtube.png" alt="YOUTUBE"></a>
                        </div><!--#footerContent-->                      
                    <address>ⓒ 2022 Yeonghwan All Rights Reserved <a href="/admin">#</a></address>
                </div><!--.footer-->
            </div><!--.row-->
        </div><!--.container-->
    </footer><!--#footer-->
<!-- 푸터영역 끝 -->