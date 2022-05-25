function check(){
    if(!confirm("글을 작성하시겠어요?")){
        alert("글작성을 취소하셨습니다.");
        return false;
    }else{
        if($("#qna_title").val()==""){
            alert("제목을 입력해주세요!");
            $("#notice_title").focus();
            return false;
        }else if($("#qna_wrnick").val() == ""){
            alert("로그인을 하신 것이 맞을까요?");
            return false;
        }else if($("#qna_content").val() == ""){
            alert("본문 내용을 입력하셨나요?");
            $("#qna_content").focus();
            return false;
        }else{
            alert("글 작성이 완료되었습니다.");
            return true;
        }
    }
}