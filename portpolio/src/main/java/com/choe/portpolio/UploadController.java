package com.choe.portpolio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import com.choe.dto.AttachFileDTO;
import org.springframework.core.io.Resource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnailator;

@Controller
public class UploadController {
	// uploadForm.jsp 실행하기 위해
	@RequestMapping(value="/uploadForm", method=RequestMethod.GET)
	public void uploadForm() {
		
	}
	
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//현재 날짜 (오늘 날짜) : Sun Dec 17 1995 03:24:00 GMT.. -> 1995-10-17
		Date date = new Date();
		
		String str = sdf.format(date);
//		맥에서는 경로가 다를 수 있기 때문에 File.separtor를 사용함
		return str.replace("-", File.separator);
		
	}
	
	// 사용자가 업로드한 파일이 이미지 타입인지를 검사하는 메소드 (이미지 타입 : true, 이미지 타입이 아니면 false)
	private boolean checkImageType(File file) {
		
		try {
			// 파일 업로르도된 경로의 파일의 유형을 파악(probContentType)
			String contentType = Files.probeContentType(file.toPath());
			return contentType.startsWith("image");
		}catch(Exception e) {
			
		}
		return false;
	}
	
	
	@RequestMapping(value="/uploadFormAction", method=RequestMethod.POST)
	public void uploadFormPost(MultipartFile[] uploadfile) {
		String uploadFolder = "D:\\upload";
		
		// 폴더 생성
		File uploadPath = new File(uploadFolder,getFolder());
		System.out.println(uploadPath);
		
		if(uploadPath.exists()==false) { // 만들고자 하는 폴더가 없으면
		uploadPath.mkdirs(); // make directory : 폴더를 만든다.
		}
		
		//	타입				변수명		:	배열명
		for(MultipartFile multipartfile:uploadfile) {
			System.out.println("사용자가 업로드한 실제 파일명  = " + multipartfile.getOriginalFilename());
			System.out.println("사용자가 업로드한 실제 파일크기  = " + multipartfile.getSize());
			System.out.println("사용자가 업로드한 실제 파일크기  = " + multipartfile.getName());
			System.out.println("사용자가 업로드한 파일 종류  = " + multipartfile.getContentType());
			System.out.println("사용자가 업로드한 파일 클래스  = " + multipartfile.getClass());
			
			File saveFile = new File(uploadPath,multipartfile.getOriginalFilename());
			
			try {
			multipartfile.transferTo(saveFile);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
		} // end for
		
		
	}
	
	// UploadAjax.jsp를 실행하기 위해
	@RequestMapping(value="/uploadAjax", method=RequestMethod.GET)
	public void uploadAjax() {	
		
	}
	
	@RequestMapping(value="/uploadAjaxAction", produces=MediaType.APPLICATION_JSON_UTF8_VALUE,method=RequestMethod.POST)
	public ResponseEntity<ArrayList<AttachFileDTO>> uploadAjaxPost(MultipartFile[] uploadfile) {
		
		// 제네릭
		ArrayList<AttachFileDTO> list = new ArrayList<>();
		
		String uploadFolder = "D:\\upload";
		// 폴더 생성
		File uploadPath = new File(uploadFolder,getFolder());
		System.out.println(uploadPath);
		
		if(uploadPath.exists()==false) { // 만들고자 하는 폴더가 없으면
		uploadPath.mkdirs(); // make directory : 폴더를 만든다.
		}
		
		//	타입				변수명		:	배열명
		for(MultipartFile multipartfile:uploadfile) {
			
			AttachFileDTO attachDTO = new AttachFileDTO();
			
			System.out.println("사용자가 업로드한 실제 파일명  = " + multipartfile.getOriginalFilename());
			System.out.println("사용자가 업로드한 실제 파일크기  = " + multipartfile.getSize());
			System.out.println("사용자가 업로드한 실제 파일크기  = " + multipartfile.getName());
			System.out.println("사용자가 업로드한 파일 종류  = " + multipartfile.getContentType());
			System.out.println("사용자가 업로드한 파일 클래스  = " + multipartfile.getClass());
			
			String uploadFileName = multipartfile.getOriginalFilename();
			// uploadFileName을 AttachFileDTO에 fileName을 변수에 저장
			attachDTO.setFilegroup_filename(uploadFileName);
			
			// UUID 문자열 생성
			UUID uuid = UUID.randomUUID();
			// UUID 문자열 + "_" + 
			uploadFileName=uuid.toString()+"_"+uploadFileName;
			
			// getFolder()메소드에 의해 만들어진 폴더를 AttachFileDTO에 uploadPath변수에 저장
			attachDTO.setFilegroup_uploadpath(getFolder());
			
			// uuid 문자열을 AtttachFileDTI에 uuid변수에 저장
			attachDTO.setFilegroup_uuid(uuid.toString());
			
			System.out.println(uploadFileName);
			
			File saveFile = new File(uploadPath,uploadFileName);
			try {
				multipartfile.transferTo(saveFile);
				if(checkImageType(saveFile)) { // saveFile에 있는 파일이 checkImageType메소드에 의해서 true면
					attachDTO.setFilegroup_image(true);
					// 원본 이미지 파일을 그대로 둔 채로, 섬네일을 새로 만들기 위한..
					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath,"s_"+uploadFileName));
					// 썸네일 생성						(원본이미지 복사, 	새로운이미지생성(UUID_s_파일명), 넓이,높이)
					Thumbnailator.createThumbnail(multipartfile.getInputStream(), thumbnail, 250, 250);
					// 메모리에서 썸네일 회수
					thumbnail.close();
					
					
				}
				list.add(attachDTO);
			}catch(Exception e) {
				System.out.println(e.getMessage());
				}
			}// end for
		return new ResponseEntity<>(list, HttpStatus.OK);
		} // uploadAjaxPost end
	
	// 이미지 주소 만들기 (localhost:8080/display?fileName=경로/파일명)
	@RequestMapping(value="/display", method=RequestMethod.GET)
	public ResponseEntity<byte[]> getFile(String fileName) {
		System.out.println("fileName = " + fileName); 
		File file = new File("D:\\upload\\" +  fileName);
		
		ResponseEntity<byte[]> result = null;
		
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file),headers,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 다운로드 주소 만들기(localhost:8080/download?filename=경로/파일명)
	// 웹브라우저가 다운로드 할 수 있게, applicaiton/octet-stream 지정
	@RequestMapping(value="/download", method=RequestMethod.GET, produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<Resource> downloadFile(String fileName) {
		
		Resource resource = new FileSystemResource("D:\\upload\\"+ fileName);
		
		String resourceName = resource.getFilename();
		HttpHeaders headers = new HttpHeaders();
		try {
			// 다운로드 했을 때 파일명이 한글 깨짐을 방지
			headers.add("Content-Disposition", "attachment;filename=" + new String(resourceName.getBytes("UTF-8"),"ISO-8859-1"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
		
	}
	
	@GetMapping("/deleteFile")
	@ResponseBody
	public ResponseEntity<String> deleteFile(String filename, String type){
		File file;
		try {
			file = new File("D:\\upload\\" + URLDecoder.decode(filename, "utf-8"));
			file.delete();
			if(type.equals("image")) {
				String largeFileName = file.getAbsolutePath().replace("s_", "");
				file = new File(largeFileName);
				file.delete();
				
			}
		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}
}
