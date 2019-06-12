package kr.or.ddit.file.fileService;

import static org.junit.Assert.assertEquals;
import kr.or.ddit.comment.ComDao.ComDaoTest;
import kr.or.ddit.db.file.model.FileVo;
import kr.or.ddit.db.file.service.FileService;
import kr.or.ddit.db.file.service.IfileService;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileServiceTest {

	private static final Logger logger = LoggerFactory
			.getLogger(ComDaoTest.class);
	
	private IfileService service;
	
	@Before
	public void setup() {
		service = new FileService();
	}
	
	/**
	 * Method : insertFile
	 * 작성자 : PC13
	 * 변경이력 :
	 * @param fileVo
	 * @return
	 * Method 설명 : 첨부파일 등록
	 */
	@Test
	public void insertFile() {
		/***Given***/
		FileVo fileVo = new FileVo();
		int file_id = 20;
		String file_name = "brown";
		String file_path = "D:/upload";
		int text_id = 110;
		
		fileVo.setFile_id(file_id);
		fileVo.setFile_name(file_name);
		fileVo.setFile_path(file_path);
		fileVo.setText_id(text_id);

		/***When***/
		service.insertFile(fileVo);

		/***Then***/
		assertEquals(1, service.insertFile(fileVo));
		
	}

	/**
	 * Method : fileList
	 * 작성자 : PC13
	 * 변경이력 :
	 * @param text_id
	 * @return
	 * Method 설명 : 해당 게시물의 첨부파일 리스트
	 */
	@Test
	public void fileList() {
		/***Given***/
		int text_id = 110;

		/***When***/
		service.fileList(text_id);
		logger.debug("dao.fileList(text_id) : {}" , service.fileList(text_id));
		/***Then***/
		assertEquals("brown", service.fileList(text_id).get(0).getFile_name());
		
	}
	
	
	/**
	* Method : getfile
	* 작성자 : PC13
	* 변경이력 :
	* @param fileVo
	* @return
	* Method 설명 : 파일 하나의 정보
	*/
	@Test
	public void getfile() {
		/***Given***/
		int file_id = 118;

		/***When***/
		service.getfile(file_id);
		logger.debug("dao.getfile(file_id) : {}" ,service.getfile(file_id));
		/***Then***/
		assertEquals("brown", service.getfile(file_id).getFile_name());
		
	}
	
	/**
	* Method : del
	* 작성자 : PC13
	* 변경이력 :
	* @param file_id
	* @return
	* Method 설명 : 첨부파일 하나지우는!
	*/
	@Test
	public void del() {
		/***Given***/
		int file_id = 117;

		/***When***/
		service.del(file_id);
		
		/***Then***/
		assertEquals(0, service.del(file_id));

		
	}
}