package kr.or.ddit.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PartUtil {

	private static final String D_UPLOAD = "d:\\upload\\";

	/**
	 * Method : getFileName 작성자 : PC13 변경이력 :
	 * 
	 * @param contentDisposition
	 * @return Method 설명 : contentDisposition에서 파일명을 반환한다.
	 */
	public static String getFileName(String contentDisposition) {
		// form-data; name="profile"; filename="sally.png"

		String[] file = contentDisposition.split("; ");
		String fileValue = "";

		for (String str : file) {
			if (str.startsWith("filename=")) {
				String[] fileStr = str.split("\"");
				fileValue = fileStr[1];
				break;
			}
		}
		return fileValue;
	}

	/**
	 * Method : getExt 작성자 : PC13 변경이력 :
	 * 
	 * @param fileName
	 * @return Method 설명 : 파일명으로부터 파일 확장자를 반환
	 */
	public static String getExt(String fileName) {
		// 방법1
		String str = "";
		if (fileName.contains(".")) {
			str = fileName.substring(fileName.lastIndexOf("."));
		}
		return str;

		// 방법2
		// String[] splited = fileName.split("\\."); //[.] 도 가능
		// if(splited.length ==1){
		// return "";
		// }else{
		// return splited[splited.length-1];
		// }
	}

	/**
	 * Method : checkuploadFolder 작성자 : PC13 변경이력 :
	 * 
	 * @param yyyy
	 * @param mm
	 *            Method 설명 : 년, 월 업로드 폴더가 존재하는지 체크, 없을 경우 폴더 생성
	 */
	public static void checkuploadFolder(String yyyy, String mm) {
		// 년도에 해당하는 폴더가 있는지, 년도안에 월에 해당하는 폴더가 있는지 검색필요
		File YFolder = new File(D_UPLOAD + yyyy);
		// 신규년도로 넘어갔을때 해당 년도의 폴더를 생성한다.
		if (!YFolder.exists()) {
			// 디렉토리 생성?
			YFolder.mkdir();
		}

		// 월에 해당하는 폴더가 있는지 확인
		File MFolder = new File(D_UPLOAD + yyyy + File.separator + mm);
		if (!MFolder.exists()) {
			// 디렉토리 생성?
			MFolder.mkdir();
		}

	}
	//D_UPLOAD 상후화 시킴 

	/**
	 * Method : getUploadPath 작성자 : PC13 변경이력 :
	 * 
	 * @param yyyy
	 * @param mm
	 * @return Method 설명 : 업로드 경로를 반환
	 */
	public static String getUploadPath() {
		// 업로드할 폴더 확인
		Date dt = new Date();
		SimpleDateFormat yyyymmSdf = new SimpleDateFormat("yyyyMM");
		
		String yyyymm = yyyymmSdf.format(dt);
		String yyyy = yyyymm.substring(0, 4);
		String mm = yyyymm.substring(4, 6);

		PartUtil.checkuploadFolder(yyyy, mm);
		return D_UPLOAD + yyyy + File.separator + mm;
	}

}
