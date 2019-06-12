package kr.or.ddit.text.TextDao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import kr.or.ddit.comment.ComDao.ComDaoTest;
import kr.or.ddit.db.text.dao.ItextDao;
import kr.or.ddit.db.text.dao.TextDao;
import kr.or.ddit.db.text.model.TextVo;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextDaoTest {

	private static final Logger logger = LoggerFactory
			.getLogger(ComDaoTest.class);
	
	private ItextDao dao;
	
	@Before
	public void setup() {
		dao = new TextDao();
	}
	
	/**
	* Method : insertText
	* 작성자 : PC13
	* 변경이력 :
	* @param textVo
	* @return
	* Method 설명 : 게시글 등록
	*/
	@Test
	public void insertText() {
		/***Given***/
		TextVo textVo = new TextVo();
		int board_id = 1;
		String col = "Y";
		int group_num = 93;
		int lv = 1;
		String text_content = "brown";
		String text_title = "brown";
		int text_id = 110;
		int text_id2 = 94;
		Date text_date = new Date();
		String userid = "brown";
		
		textVo.setBoard_id(board_id);
		textVo.setCol(col);
		textVo.setGroup_num(group_num);
		textVo.setLv(lv);
		textVo.setText_content(text_content);
		textVo.setText_date(text_date);
		textVo.setText_id(text_id);
		textVo.setText_id2(text_id2);
		textVo.setText_title(text_title);
		textVo.setUserid(userid);

		/***When***/
		dao.insertText(textVo);

		/***Then***/
		assertEquals(1, dao.insertText(textVo));

	}

	/**
	* Method : textVo
	* 작성자 : PC13
	* 변경이력 :
	* @param board_id
	* @return
	* Method 설명 : board에 쓰여진 text다 불러오기
	*/
	@Test
	public void allText() {
		/***Given***/
		int board_id = 1;

		/***When***/
		dao.allText(board_id);
		logger.debug("dao.allText(board_id) : {} ", dao.allText(board_id));
		/***Then***/
		assertEquals(1, dao.allText(board_id).get(0).getBoard_id());
	}

	/**
	* Method : getText
	* 작성자 : PC13
	* 변경이력 :
	* @param text_id
	* @return
	* Method 설명 : 해당 text 번호로 게시글 한개 조회
	*/
	@Test
	public void getText() {
		/***Given***/
		int text_id = 110;

		/***When***/
		dao.getText(text_id);
		logger.debug("dao.getText(text_id) : {} ",dao.getText(text_id));
		/***Then***/
		assertEquals(110, dao.getText(text_id).getText_id());
	}
	
	/**
	* Method : updateText
	* 작성자 : PC13
	* 변경이력 :
	* @param textVo
	* @return
	* Method 설명 : 게시글 업데이트
	*/
	@Test
	public void updateText() {
		/***Given***/
		TextVo textVo = new TextVo();
		int board_id = 1;
		String col = "Y";
		int group_num = 93;
		int lv = 1;
		String text_content = "brown1";
		String text_title = "brown1";
		int text_id = 110;
		int text_id2 = 94;
		Date text_date = new Date();
		String userid = "brown";
		
		textVo.setBoard_id(board_id);
		textVo.setCol(col);
		textVo.setGroup_num(group_num);
		textVo.setLv(lv);
		textVo.setText_content(text_content);
		textVo.setText_date(text_date);
		textVo.setText_id(text_id);
		textVo.setText_id2(text_id2);
		textVo.setText_title(text_title);
		textVo.setUserid(userid);

		/***When***/
		dao.updateText(textVo);
		
		/***Then***/
		assertEquals(1, dao.updateText(textVo));
	}
	
}
