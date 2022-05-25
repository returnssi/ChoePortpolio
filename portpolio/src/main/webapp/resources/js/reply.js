/** 
 * 
 */
$(document).ready(function(){
	var qna_id = $("#qna_id").val();
	//DB select해서 댓글 목록 리스트를 하는 함수 호출
	list(qna_id);
	$("#replyWriteBtn").show();
	$("#replymodBtn").hide();
	$("#replydelBtn").hide();
		
	
	// modal 창 안에 있는 댓글쓰기 버튼을 클릭하면
	$("#replyWriteBtn").on("click", function(){
		// 사용자가 입력한 댓글내용을 가져오기
		var qreply_comment = $("#qreply_comment").val();
		var qreply_nickname = $("#qreply_nickname").val();
		// 사용자가 입력한 댓글작성자를 가져오기
		var qreply_wrid = $("#qreply_wrid").val();
		// 현재 게시판 번호를 가져오기
		var qna_id = $("#qna_id").val();
		
		// DB Insert하는 함수 호출
//		console.log("댓글 추가");
//		console.log(reply);
//		console.log(replyer);
//		console.log(qna_id);
		
		// 변수명:값
		add({qreply_comment:qreply_comment,qreply_nickname:qreply_nickname,qreply_wrid:qreply_wrid,qna_id:qna_id});
//		$("#reply").val("");
	}) 
	
	// 댓글목록리스트에서 댓글내용을 클릭하면
	$(".replyList").on("click","li", function(){
		
		// 사용자가 선택한 댓글번호(rno)를 가져오기
		var qreply_no=$(this).data("qreply_no");
		console.log(qreply_no);
		
		// 댓글 목록리스트를 클릭한 후 띄워지는 모달창에 select된 결과 뿌리기
		get(qreply_no);
		// 모달 창 안에 있는 rno입력란 안에 rno를 넣어라
		$("#replyWriteBtn").hide();
		$("#replymodBtn").show();
		$("#replydelBtn").show();
		
		$("#qreply_no").val(qreply_no);
		$("#qreply_comment").val(qreply_comment);
		$("#qna_id").val(qna_id);
		
		
//		$(".modal").modal("show");
//		$("#modalModBtn").show();
//		$("#modalRemoveBtn").show();
//		$("#replydate").hide();
//		$("#modalWriteBtn").hide();
	})// 댓글목록리스트에서 댓글내용을 클릭하면 end
	
	// 모달창안에 있는 댓글 수정 버튼을 클릭하면
	$("#replymodBtn").on("click",function(){
		
		// 댓글내용(rno)값 가져오기
		var qreply_no = $("#qreply_no").val();
		console.log(qreply_no);
		// 댓글내용(reply)값 가져오기
		var reply = $("#qreply_comment").val();
		console.log(qreply_comment);
		
		var reply = $("#qreply_wrid").val();
		console.log(qreply_wrid);
		
		var reply = $("#qna_id").val();
		console.log(qna_id);
		
		
		// 모달창 안에 있는 댓글 수정 버튼을 클릭하면 댓글내용이 수정되는 update기능을 하는 함수 호출
		// modify(댓글번호변수:댓글번호값,댓글내용변수:댓글내용값)
		modify({qreply_no:$("#qreply_no").val(),qreply_comment:$("#qreply_comment").val(),qreply_wrid:$("#qreply_wrid").val(),qna_id:qna_id});
		
		$("#qreply_no").val("");
		$("#qreply_comment").val("");
		
		$("#replyWriteBtn").show();
		$("#replymodBtn").hide();
		$("#replydelBtn").hide();
		
	})
	
	// 모달창안에 있는 댓글 삭제 버튼을 클릭하면
	$("#replydelBtn").on("click",function(){
		// 댓글번호
		var qreply_no = $("#qreply_no").val();
		// 모달창안에 있는 댓글 삭제가 되도록 delete를 하는 함수 호출
		remove(qreply_no);
	})
	
}) // $(document).ready(function(){} 끝나는 부분

// DB Insert하는 함수 선언
function add(reply){
	console.log("댓글 추가");
	console.log(reply);
	// AJAX()를 이용하여 DB에 INSERT하는 것을 작성
	$.ajax({
		// select / insert / update/ delete
		// type get or post or put or delete
		// url (필수) 나머진 선택사항 - controller의 @RequestMapping의 value
		// date : controller의 메소드의 매개변수의 의해서 수집되는 데이터(JSON)
		// contentType
		// processType
		// success
		// error
		
		type:"post",
		url:"/replies/new",
		data : JSON.stringify(reply), // JSON.stringify메소드는 json객체를 String 객체로 변환시켜주는 메소드
		contentType : "application/json; charset=utf-8", // 웹브라우저한테 json타입을 하이브리드 보냄 (보내는 자원의 형식을 명시하기 위해 헤더에 실리는 정보)
		success:function(result){
				console.log(result)
				if(result=="success"){
//				alert("insert됨.")
				list(reply.qna_id);
				$('#replyModal').modal("hide");
				$("#qreply_comment").val("");
				}
			}
	})
	
}
//DB select해서 댓글 목록 리스트를 하는 함수 선언
function list(qna_id){
	console.log("댓글 목록 리스트");
	console.log(qna_id);
	// ajax()를 이용하여 DB에 select하는 것을 작성
	$.getJSON("/replies/list/"+qna_id+".json", function(data){
		// Select가 정상적으로실행되고 난 후 처리
		console.log(data);
		var str = "";
		for(var i = 0; i < data.length; i++){
			str +="<li data-qreply_no="+data[i].qreply_no +"><div>";
			str += "<div id='replyContents'><p id='nickname'>" + data[i].qreply_nickname + "</p><p>" + data[i].qreply_date  + "<p></div>";
			str += "<div>"+data[i].qreply_comment+"</div>";
			str += "</div></li>";
		}
		$(".replyList").html(str);
		
	})
}
// DB select하는 함수 선언
function get(qreply_no){
	// ajax이용해서 select작업
	// $.getJSON(url주소,콜백함수);
	console.log("댓글 내용 보기");
	$.getJSON("/replies/detail/"+qreply_no +".json", function(data){
		console.log("댓글 내용 : "+data.qreply_comment);
		qreply_comment = data.qreply_comment;
//		// 모달창 안에 있는 reply를 선택한 후 값을 저장
//		$("#qreply_comment").val(data.reply);
//		// 모달창 안에 있는 replyer를 선택한 후 값을 저장
//		$("#replyer").val(data.reply);
	});
}
// DB update하는 함수 선언
function modify(reply){
	console.log("댓글 수정 보기");
	console.log(reply);
	// ajax()
	$.ajax({
		type: "put",
		url: "/replies/modify",
		data: JSON.stringify(reply),
		contentType: "application/json; charset=utf-8",
		success: function(result){
			if(result=="success"){
				$('#replyModal').modal("hide"); // 모달창 숨기기
				list(reply.qna_id); // 새로고침
				
			}
		}
	})
}
// DB delete하는 함수 선언
function remove(qreply_no, qna_id){
	console.log("댓글 내용 삭제");
	// 모달창안에 있는 댓글 삭제가 되도록 delete를 하는 함수 선언
	$.ajax({
		type: "delete",
		url: "/replies/remove/" + qreply_no,
		success: function(result){
			if(result=="success"){
				list(qna_id); // 새로고침
				
			}
		}
	})
}