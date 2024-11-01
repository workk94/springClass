package aa.bb.tt;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriUtils;

 
@Controller
public class SimpleController {
	
	 private String fileDir ="c:\\test\\upload\\";  // 미리 폴더를 만들어야함
	 
	 
	 @GetMapping("/upload")
	 public String uploadForm() {
		 return "form";
	 }

	 
	
	@PostMapping("/upload")
	public String upload( String  goodsCode   , MultipartFile file , Model model) throws IllegalStateException, IOException {
	    	System.out.println( goodsCode);
		 
	        if (!file.isEmpty()) {  // 빈파일이 아닌경우 (업로드한 파일이 있다면)
	        	
	         	String fileRealName  = file.getOriginalFilename(); 	     // 원본파일이름       
	        	String fullPath = fileDir + fileRealName;                // 전체 경로명 포함한 파일명
	        	file.transferTo(new File(fullPath));                     // upload  (업로드한 파일이 서버에 생성됨)     
	    
	         
	            model.addAttribute("fileName" ,fileRealName);          
	        }

		return "upload-ok";
		
		
	}
 
	 
 
	
	// 이미지 리소스  응답하기
	@ResponseBody	
	@RequestMapping( value="/images/{fileName:.*}" , method=RequestMethod.GET)
	public Resource image(@PathVariable String  fileName) throws MalformedURLException {		
		System.out.println( "fileName" + fileName);
		return  new  UrlResource("file:c:\\test\\upload\\"+ fileName);
		//서버의 리소스(자원)을 제공할 때 사용
	}	

	
	/* 
	 * 
	  PathVariable란? path뒤에  /뒤에 값을 전달하고 서버가 전달 받을 수 있다.
	  /images/aaa.jpg      fileName( 경로변수=> aaa.jpg)
	  /images/aaa
	  /images/aaaa.jpeg
	  /images/{fileName:.*}" 패턴은 일반적으로 웹 애플리케이션에서 URL 경로를 처리하기 위해 사용되는 패턴
	*/
	
	
	@GetMapping(value = "/images2/{fileName:.*}")
    public ResponseEntity<Resource> image2(@PathVariable String fileName) throws MalformedURLException {
        Resource resource = new UrlResource("file:c:\\test\\upload\\" + fileName);       
        return ResponseEntity.ok()
                .body(resource);
    }
	
	
	
	@RequestMapping( value="/attach/{fileName:.*}" , method=RequestMethod.GET)
	public ResponseEntity<Resource> fileDownload(@PathVariable String  fileName) throws MalformedURLException, UnsupportedEncodingException {		
	 
		//서버의 리소스(자원)을 제공할 때 사용
		Resource  resource=  new  UrlResource("file:c:\\test\\upload\\"+ fileName);		
		//파일이름이 한글문제로  encode작업함
	 	String encodedUploadFileName = URLEncoder.encode(fileName, "UTF-8");	 	
	 	//응답헤더정보에 attachment라는 정보제공해야함(다운로드가 성공한다)
		String contentDispositon = "attachment; filename=\""+ encodedUploadFileName + "\"";	 
		return   ResponseEntity.ok().header( HttpHeaders.CONTENT_DISPOSITION, contentDispositon).body(resource);
		
	}
}



