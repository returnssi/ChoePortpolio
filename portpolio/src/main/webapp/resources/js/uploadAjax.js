// 파일의 확장자(exe,sh,zip,alz)업로드 제한
var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");

// 크기
var maxSize=5242880; // 5MB미만으로 제한

//파일 확장자나 크기의 제한하는 기능의 함수선언
function checkExtension(fileName,fileSize){
	if(fileSize>=maxSize){
		alert("파일 사이즈 초과");
		return false;
	}
	if(regex.test(fileName)){
		alert("해당 종류의 파일은 업로드 할 수 없습니다.");
		return false;
	}
	return true;
}



$(document).ready(function(){
	var formObj = $("form[role='form']")
	$("#uploadBtn").on("click", function(e){
		e.preventDefault();
//		alert("클릭됨");
		var str="";
		$("#uploadResult ul li").each(function(i, obj){
			console.log($(obj));
			str += "<input type='text' name='attach["+i+"].filegroup_filename' value='"+ $(obj).data("filename")+"'>"
			str += "<input type='text' name='attach["+i+"].filegroup_uploadpath' value='"+ $(obj).data("path")+"'>"
			str += "<input type='text' name='attach["+i+"].filegroup_uuid' value='"+ $(obj).data("uuid")+"'>"
			str += "<input type='text' name='attach["+i+"].filegroup_image' value='"+ $(obj).data("image")+"'>"
		})
		formObj.append(str).submit();
	})
	// uploadAjax.jsp에 있는 upload버튼을 클릭하면
	// write.jsp에 있는파일선택버튼의 내용이 바뀌면(change)
	$("input[type='file']").on("change", function(){
//		alert("파일업로드 버튼 적용")
		// html과 html 같은 역활 ForData() data 객체
		// FormDate를 이용하여 <form>태그로 생각
		// Ajax를 이용하 파일업로는 FormDate를 이용하여 필요한 파라미터를 넣어서 전송
		var formData = new FormData();
		var inputFile = $("input[name='uploadFile']");
		var files = inputFile[0].files;
		
		console.log(files);
		
		for(var i=0; i<files.length; i++){
			
			if(!checkExtension(files[i].name,files[i].size)){
				return false;
			}
			
			
			// 파일정보(files[i])를 보내자
			formData.append("uploadfile", files[i]);
		}// end for
		$.ajax({
			type:"post",
			url:"/uploadAjaxAction",
			data:formData,
			processData:false,
			contentType:false,
			success:function(result){
				console.log(result.length)
				if(result.length >= 1){
					alert('업로드 성공');
					console.log(result);
					var str="";
					$(result).each(function(i,obj){
						var fileCellPath = encodeURIComponent(obj.filegroup_uploadpath + "/s_" + obj.filegroup_uuid + "_" +  obj.filegroup_filename)
						var fileLink = fileCellPath.replace(new RegExp(/\\/g),"/"); // 추가
						console.log(obj);
						// 이미지이면 true - 썸네일을 웹브라우저에 출력
						if(obj.filegroup_image){
							str += "<li data-path='"+ obj.filegroup_uploadPath + "' data-uuid='" + obj.filegroup_uuid + "' data-filename='" + obj.filegroup_filename + "' data-image='" + obj.filegroup_image + "'" + ">"
							str += "<img src='/display?fileName=" + fileCellPath + "'>"
							str += "<span data-file=\'" + fileCellPath +"'\" data-type='image'>X</span>"
							str += "</li>"
							console.log(obj.filegroup_uploadpath);
						}else{
						
						// 이미지가 아니면 false - 파일명으로 되어져있는 링크를 클릭하여 다운로드 할 수 있도록 처리
							str += "<li data-path='"+obj.filegroup_uploadpath + "' data-uuid='" + obj.filegroup_uuid + "' data-filename='" + obj.filegroup_filename + "' data-image='" + obj.filegroup_image + "'" + ">"
							str += "<a href='/download?fileName=" + encodeURIComponent(obj.filegroup_uploadpath + "/" + obj.filegroup_uuid + "_" +  obj.filegroup_filename) + "'>"+ obj.filegroup_filename +"</a>"
							str += "</li>"
						}
					})
					$("#uploadResult ul").html(str);
				}else{
					alert('업로드 실패');
					console.log(result);
				}
			}
		
		})
		
		$("#uploadResult").on("click","span",function(e){

			var targetFile = $(this).data("file");
			var type = $(this).data("type");
			$.ajax({
				url: "/deleteFile",
				data: {filename: targetFile, type:type},
				dataType: 'text',
				tpye: 'get',
				success: function(result){
					alert(result);
					$("#uploadResult").remove($("this"));
				}
			});
		});
	}) 
})