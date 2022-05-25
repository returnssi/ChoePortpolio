$(function(){
	$("#btnLogin").click(function(){
	 userid=$("#m_id").val();
	 var passwd=$("#m_password").val(); if(userid == ""){
	  alert("아이디를 입력하세요");
	  $("#m_id").focus(); //입력포커스 이동
	
	  return; //함수 종료
 }
		if(passwd==""){
		 alert("비밀번호를 입력하세요"); 
		 $("#m_password").focus();
		  return;
		}
	});
});