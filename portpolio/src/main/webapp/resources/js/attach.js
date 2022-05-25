/**
 * 
 */
$(document).ready(function(){
	
	var qna_id = $("#qna_id").val();


	$.getJSON("/attach", {qna_id:qna_id},function(attachList){
		console.log(attachList);
		var str="";
		// select한 후 boardDetail.jsp에 출력
		$(attachList).each(function(i,attach){
			// 이미지이면(썸네일을 웹브라우저에 출력)
			if(attach.isImage==0){
				alert("파일이 없습니다.");
			}else if(attach.filegroup_image){
				str += "<li data-path='"+attach.filegroup_uploadPath + "' data-uuid='" + attach.filegroup_uuid + "' data-filename='" + attach.filegroup_filename + "' data-image='" + attach.filegroup_image + "'" + ">"
				str += "<img src='/display?fileName=" + encodeURIComponent(attach.filegroup_uploadpath + "/s_" + attach.filegroup_uuid + "_" +  attach.filegroup_filename) + "'>"
				str += "</li>"
			}else{ // 이미지가 아니면 (파일명으로 되어 있는 링크를 클릭해서 다운로드 할 수 있도록 처리)
				str += "<li data-path='"+attach.filegroup_uploadPath + "' data-uuid='" + attach.filegroup_uuid + "' data-filename='" + attach.filegroup_filename + "' data-image='" + attach.filegroup_image + "'" + ">"
				str += "<a href='/download?fileName=" + encodeURIComponent(attach.filegroup_uploadpath + "/" + attach.filegroup_uuid + "_" +  attach.filegroup_filename) + "'>"+ attach.filegroup_filename +"'</a>"
				str += "</li>"
			}
			$("#uploadResult ul").html(str);
		})
	})
	
})