package kr.or.ddit.comment.ComService.java;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import kr.or.ddit.comment.ComDao.ComDaoTest;
import kr.or.ddit.db.comment.model.CommentVo;
import kr.or.ddit.db.comment.service.ComService;
import kr.or.ddit.db.comment.service.icomService;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComServiceTest {

	private static final Logger logger = LoggerFactory
			.getLogger(ComDaoTest.class);
	
	private icomService service;
	
	@Before
	public void setup() {
		service = new ComService();
	}
	/**
	* Method : insertCom
	* 작성자 : PC13
	* 변경이력 :
	* @param comVo
	* @return
	* Method 설명 : 댓글 등록
	*/
	@Test
	public void insertCom() {
		/***Given***/
		CommentVo comVo = new CommentVo();
		String col ="Y";
		String com_content = "123";
		Date com_date = new Date();
		int com_id = 50;
		int text_id = 120;
		String userid = "brown";
		
		comVo.setCom_id(com_id);
		comVo.setText_id(text_id);
		comVo.setCom_content(com_content);
		comVo.setCom_date(com_date);
		comVo.setCol(col);
		comVo.setUserid(userid);

		/***When***/
		service.insertCom(comVo);
		
		/***Then***/
		assertEquals(1, service.insertCom(comVo));
	}

	/**
	* Method : Comselect
	* 작성자 : PC13
	* 변경이력 :
	* @param text_id
	* @return
	* Method 설명 : 해당 게시물 번호에 있는 댓글 리스트 조회
	*/
	@Test
	public void Comselect() {
		
		/***Given***/
		
		int text_id = 120;
		/***When***/
		service.Comselect(text_id);
		logger.debug("dao.Comselect(text_id) : {}",service.Comselect(text_id));
		/***Then***/
		assertEquals("brown", service.Comselect(text_id).get(0).getUserid());

	}
	
	/**
	* Method : changeCol
	* 작성자 : PC13
	* 변경이력 :
	* @param com_id
	* @return
	* Method 설명 : 댓글 상태를 Y --> N으로 변경
	*/
	@Test
	public void changeCol() {
		/***Given***/
		int com_id =38;	

		/***When***/
		service.changeCol(com_id);
		logger.debug("dao.changeCol(com_id) : {}" , service.changeCol(com_id));
		/***Then***/
		assertEquals(1, service.changeCol(com_id));
		
		
	}

}
