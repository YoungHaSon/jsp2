package kr.or.ddit.db.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.board.model.BoardVo;
import kr.or.ddit.mybatis.MyBatisUtil;

public class BoardDao implements IboardDao {
	
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
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int insertBoard = (Integer) sqlSession.insert("board.insertBoard",boardVo);
		sqlSession.commit();
		sqlSession.close();
		return insertBoard;
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
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<BoardVo> boardList = sqlSession.selectList("board.boardAllList");
		sqlSession.close();
		return boardList;
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
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<BoardVo> boardList = sqlSession.selectList("board.boardList");
		sqlSession.close();
		return boardList;
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
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		BoardVo boardVo = sqlSession.selectOne("board.getBoard",board_id);
		sqlSession.close();
		return boardVo;
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
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int updateY = sqlSession.update("board.updateBoardYN",boardVo);
		sqlSession.commit();
		sqlSession.close();;
		return updateY;
	}
	
	

}
