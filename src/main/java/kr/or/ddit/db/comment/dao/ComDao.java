package kr.or.ddit.db.comment.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.board.model.BoardVo;
import kr.or.ddit.db.comment.model.CommentVo;
import kr.or.ddit.mybatis.MyBatisUtil;

public class ComDao implements IcomDao {

	@Override
	public int insertCom(CommentVo comVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int insertCom = (Integer) sqlSession.insert("com.insertCom",comVo);
		sqlSession.commit();
		sqlSession.close();
		return insertCom;
	}

	@Override
	public List<CommentVo> Comselect(int text_id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<CommentVo> Comselect = sqlSession.selectList("com.Comselect",text_id);
		sqlSession.commit();
		sqlSession.close();;
		return Comselect;
	}

	@Override
	public int changeCol(int com_id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int changeCol = sqlSession.update("com.changeCol",com_id);
		sqlSession.commit();
		sqlSession.close();;
		return changeCol;
	}
	

	
}
