package kr.or.ddit.db.board.dao;

import java.util.List;

import kr.or.ddit.db.board.model.BoardVo;

public interface IboardDao {

	/**
	* Method : insertBoard
	* 작성자 : PC13
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 등록
	*/
	int insertBoard(BoardVo boardVo);

	/**
	* Method : boardList
	* 작성자 : PC13
	* 변경이력 :
	* @return
	* Method 설명 : Y인 게시판 전체 조회
	*/
	List<BoardVo> boardList();
	
	/**
	* Method : boardAllList
	* 작성자 : PC13
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 전체 조회
	*/
	List<BoardVo> boardAllList();
	
	/**
	* Method : getBoard
	* 작성자 : PC13
	* 변경이력 :
	* @param boardId
	* @return
	* Method 설명 : 게시판 한개 가져오기
	*/
	BoardVo getBoard (int board_id);
	
	/**
	* Method : updateBoardY
	* 작성자 : PC13
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 사용여부 설정
	*/
	int updateBoardYN (BoardVo boardVo);
	
	
	
}
