package kh.study.intranet.config;

import java.io.File;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import kh.study.intranet.main.vo.UserVO;

public class uploadFileUtil {
	private static final String UPLOAD_PATH ="D:\\dev\\workspaceSTS\\4Men-Intranet\\src\\main\\resources\\static\\imgs\\user\\";
	
	
	
	//파일첨부 
	public static UserVO uploadFile(MultipartFile empPictureOriginName) {
		
//		String fileName = null;
//		String originFileName = null; 
		String fileName = null;
		String originFileName = null; 
		
		if(!empPictureOriginName.getOriginalFilename().equals("")) {
			
			//첨부하려는 원본 파일명 등록
			originFileName = empPictureOriginName.getOriginalFilename();
			
			// UUID.randomUUID : 파일명 중복을 막기 위해 랜덤판 파일명을 문자열로 생성
			String uuid = UUID.randomUUID().toString();
			
			//extention : 확장자를 추출한다. db에파일명은 랜덤생성 + 확장자로 들어간다
			String extension =originFileName.substring(originFileName.lastIndexOf("."));
			
			//첨부될 파일명
			fileName = uuid + extension;
			
				try {
					
					//파일 객체를 생성한다, 예외처리가 없다면 문제가 생기기때문에 자동으로 오류를뱉는다
					File file = new File(UPLOAD_PATH + fileName);
					empPictureOriginName.transferTo(file);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
		}
		
		//imgVO 에 데이터 담아준다
		UserVO userVO = new UserVO();
		userVO.setEmpPictureOriginName(originFileName);
		userVO.setEmpPictureRefileName(fileName);
		
		
		return userVO;
	}
}