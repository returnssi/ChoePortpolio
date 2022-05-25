$(document).ready(function(){
	// 검색버튼을 클릭했을 때
	$("#searchbtn").on("click", function(e){
		// 검색종류가 선택이 되어 있지 않으면
		if($("#type").val()==""){
			alert("검색종류를 선택하세요.");
			return false;
		}
		if($("#keyword").val()==""){
		// 키워드가 입력되어 있지 않으면
		 	alert("키워드를 입력하세요.");
		 	return false;
		}
		// 검색버튼 클릭시 무조건 1페이지부터 검색할 수 있도록
		// pagenum을 1로 셋팅
		$("#pagenum").val('1');
		$("#amount").val('10');
		$("#searchForm").submit();
	}) // 검색 버튼을 클릭했을 때의 끝
	
	// 페이지 번호(아이디가 pageNo)를 클릭했을 때
	$(".pageNo").on("click",function(e){
		e.preventDefault();
		console.log($(this).attr("href"));
		$("#pagenum").val($(this).attr("href"));

		$("#searchForm").submit();
	})
	
	// 페이지 번호를 클릭했을 때의 끝
	
})
