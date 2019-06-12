package kr.or.ddit.board.BoardService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import kr.or.ddit.board.BoardDao.BoardDaoTest;
import kr.or.ddit.db.board.model.BoardVo;
import kr.or.ddit.db.board.service.BoardService;
import kr.or.ddit.db.board.service.IboardService;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoardServiceTest {

	private static final Logger logger = LoggerFactory
			.getLogger(BoardDaoTest.class);

	private IboardService service;

	@Before
	public void setup() {
		service = new BoardService();
	}

	
	/**
	 * Method : insertBoard 작성자 : PC13 변경이력 :
	 * 
	 * @param boardVo
	 * @return Method 설명 : 게시판 등록 Test
	 */
	@Test
	public void insertBoard() {
		/*** Given ***/
		BoardVo boardVo = new BoardVo();
		int board_id = 100;
		String board_name = "map";
		Date reg_dt = new Date();
		String use_yn = "Y";
		String userid = "brown";

		boardVo.setBoard_id(board_id);
		boardVo.setBoard_name(board_name);
		boardVo.setReg_dt(reg_dt);
		boardVo.setUse_yn(use_yn);
		boardVo.setUserid(userid);

		/*** When ***/
		service.insertBoard(boardVo);

		/*** Then ***/
		assertEquals(1, service.insertBoard(boardVo));

	}

	/**
	 * Method : boardList 작성자 : PC13 변경이력 :
	 * 
	 * @return Method 설명 : Y인 게시판 전체 조회 test
	 */
	@Test
	public void boardList() {

		/*** Given ***/

		/*** When ***/
		List<BoardVo> boardList = service.boardList();

		/*** Then ***/
		assertEquals("Y", boardList.get(0).getUse_yn());
	}

	@Test
	public void boardAllList() {

		/*** Given ***/

		/*** When ***/
		List<BoardVo> boardAllList = service.boardAllList();
		logger.debug("boardAllList : {}", boardAllList);
		/*** Then ***/
		assertEquals("자유게시판", boardAllList.get(0).getBoard_name());
	}

	/**
	 * Method : getBoard 작성자 : PC13 변경이력 :
	 * 
	 * @param boardId
	 * @return Method 설명 : 게시판 한개 가져오기
	 */
	@Test
	public void getBoard() {
		/*** Given ***/

		/*** When ***/
		BoardVo boardVo = service.getBoard(1);
		logger.debug("boardVo : {}", boardVo);
		/*** Then ***/
		assertEquals("자유게시판", boardVo.getBoard_name());
	}

	/**
	 * Method : updateBoardY 작성자 : PC13 변경이력 :
	 * 
	 * @param boardVo
	 * @return Method 설명 : 게시판 사용여부 설정
	 */
	@Test
	public void updateBoardYN() {
		/*** Given ***/
		BoardVo boardVo = new BoardVo();
		int board_id = 50;
		String board_name = "map";
		Date reg_dt = new Date();
		String use_yn = "N";
		String userid = "brown";
		
		boardVo.setBoard_id(board_id);
		boardVo.setBoard_name(board_name);
		boardVo.setReg_dt(reg_dt);
		boardVo.setUse_yn(use_yn);
		boardVo.setUserid(userid);
		
		/*** When ***/
		service.updateBoardYN(boardVo);
		/*** Then ***/
		assertEquals("N", boardVo.getUse_yn());
	}

}
