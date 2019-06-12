package kr.or.ddit.file.fileDao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import kr.or.ddit.comment.ComDao.ComDaoTest;
import kr.or.ddit.db.file.dao.FileDao;
import kr.or.ddit.db.file.dao.IfileDao;
import kr.or.ddit.db.file.model.FileVo;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileDaoTest {

	private static final Logger logger = LoggerFactory
			.getLogger(ComDaoTest.class);
	
	private IfileDao dao;
	
	@Before
	public void setup() {
		dao = new FileDao();
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
		dao.insertFile(fileVo);

		/***Then***/
		assertEquals(1, dao.insertFile(fileVo));
		
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
		dao.fileList(text_id);
		logger.debug("dao.fileList(text_id) : {}" , dao.fileList(text_id));
		/***Then***/
		assertEquals("brown", dao.fileList(text_id).get(0).getFile_name());
		
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
		dao.getfile(file_id);
		logger.debug("dao.getfile(file_id) : {}" ,dao.getfile(file_id));
		/***Then***/
		assertEquals("brown", dao.getfile(file_id).getFile_name());
		
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
		int file_id = 112;

		/***When***/
		dao.del(file_id);
		
		/***Then***/
		assertEquals(0, dao.del(file_id));

		
	}
}
