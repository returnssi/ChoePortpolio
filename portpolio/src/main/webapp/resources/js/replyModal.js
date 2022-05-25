$(document).ready(function(){
    // 모달 가져오기
    var modal = document.getElementById('replyModal');
    
    // 모달 여는 버튼 가져오기
    var btn = document.getElementById("replyList");

    // 모달 닫는 <span> 요소를 가져옵니다.
    var span = document.getElementsByClassName("close")[0];                                          

    // 사용자가 버튼을 클릭하면 모달 열기
    btn.onclick = function() {
        modal.style.display = "block";
    }

    // 사용자가 <span> (x)을 클릭하면 모달 닫기
    span.onclick = function() {
        modal.style.display = "none";
    }

    // 사용자가 모달 밖의 아무 곳이나 클릭하면 모달 닫기
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
})
