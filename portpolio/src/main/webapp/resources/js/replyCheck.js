function check(){
    if(confirm("글을 수정하시겠어요?")){
	if($("#qreply_nickname").val() == ""){
            alert("로그인을 하신 것이 맞을까요?");
            return false;
        }else if($("#qreply_comment").val() == ""){
            alert("댓글을 입력하셨나요?");
            $("#qreply_comment").focus();
            return false;
        }else{
            alert("글 수정이 완료되었습니다.");
            
        }
    }else{
    	alert("글 수정을 취소하셨습니다.");
        return false;
    }
    return true;
}