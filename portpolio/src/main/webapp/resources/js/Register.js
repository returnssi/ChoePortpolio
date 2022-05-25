var idck = 0;
var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	
$(document).ready(function(){

	    //idck 버튼을 클릭했을 때 
	    $("#idck").click(function() {
	        
	        //m_id 를 param.
	        var m_id =  $("#m_id").val(); 
	        
	        $.ajax({
	            async: true,
	            type : 'get',
	            url : "/idcheck.do/"+m_id,
	            contentType: "application/json; charset=UTF-8",
	            success : function(data) {
	            	var color;
					var ans;
	                if (data == "success") {
	                    alert("아이디가 존재합니다. 다른 아이디를 입력해주세요.");
	                    $("#resultId").text("아이디가 이미 있습니다, 다른 아이디로 해주세요");
	                    $("#resultId").css("color","red");

	                    
	                    
	                
	                } else {
	                	idck = 1;
	                	
	                    alert("사용가능한 아이디입니다.");
	                    $("#resultId").text("사용 할 수 있습니다!");
	                    $("#resultId").css("color","blue");

	                }
	            },
	            error : function(error) {
	                alert("다시 확인해주세요!");
	                System.out.println("error : " + error);
	            }
	        });
	    });
	});



function check(){
	
    if(!confirm("회원가입을 하시겠어요?")){
        alert("설마 가시는건 아니죠?ㅠ");
        return false;
    }else{
        if($("#m_id").val()==""){
            alert("아이디를 입력해주십시오");
            $("#m_id").focus();
            return false;
        }else if($("#m_password").val() == ""){
            alert("비밀번호를 입력해주십시오");
            $("#m_password").focus();
            return false;
        }else if($("#m_password").val() != $("#m_password2").val()){
            alert("비빌번호를 다르게 입력했습니다.");
            $("#m_password2").select();
            return false;
        }else if($("#m_name").val() == ""){
            alert("이름을 입력해주십시오");
            $("#m_name").focus();
            return false;
        }else if($("#m_nickname").val() == ""){
            alert("닉네임을 입력해주십시오");
            $("#m_nickname").focus();
            return false;
        }else if($("#m_phonnumber").val() == ""){
            alert("휴대폰 번호를 입력해주세요.");
            $("#m_phonnumber").focus();
            return false;
        }else if($("#m_email").val() == ""){
            alert("이메일을 입력해주십시오");
            $("#m_email").focus();
            return false;
        }else if(exptext.test($("#m_email").val())==false){
            alert("이 메일형식이 올바르지 않습니다.");
            $("#m_email").focus();
            return false;
        }else if(idck==0){
            alert('아이디 중복체크를 해주세요');
            return false;
        }
//        위 조건들을 다 통과했을 때 (Success)
        alert("회원가입을 축하합니다");
        return true;
    }
}