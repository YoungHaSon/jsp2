package kr.or.ddit.db.board.service;

import java.util.List;

import kr.or.ddit.db.board.dao.BoardDao;
import kr.or.ddit.db.board.dao.IboardDao;
import kr.or.ddit.db.board.model.BoardVo;

public class BoardService implements IboardService {

	private IboardDao dao;
	
	public BoardService(){
		dao = new BoardDao();
	}
	
	/**
	* Method : insertBoard
	* 작성자 : PC13
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 등록
	*/
	@Override
	public int insertBoard(BoardVo boardVo) {
		return dao.insertBoard(boardVo);
	}
	
	/**
	* Method : boardList
	* 작성자 : PC13
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 전체 조회
	*/
	@Override
	public List<BoardVo> boardList() {
		return dao.boardList();
	}

	/**
	* Method : getBoard
	* 작성자 : PC13
	* 변경이력 :
	* @param boardId
	* @return
	* Method 설명 : 게시판 한개 가져오기
	*/
	@Override
	public BoardVo getBoard(int board_id) {
		return dao.getBoard(board_id);
	}

	/**
	* Method : updateBoardY
	* 작성자 : PC13
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 사용여부 설정
	*/
	@Override
	public int updateBoardYN(BoardVo boardVo) {
		return dao.updateBoardYN(boardVo);
	}

	/**
	* Method : boardAllList
	* 작성자 : PC13
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 전체 조회
	*/
	@Override
	public List<BoardVo> boardAllList() {
		return dao.boardAllList();
	}

}
