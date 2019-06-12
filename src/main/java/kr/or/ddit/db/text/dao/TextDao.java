package kr.or.ddit.db.text.dao;

import java.util.List;

import kr.or.ddit.db.text.model.TextVo;
import kr.or.ddit.mybatis.MyBatisUtil;

import org.apache.ibatis.session.SqlSession;

public class TextDao implements ItextDao {

	@Override
	public int insertText(TextVo textVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int insertText = (Integer) sqlSession.insert("text.insertText",textVo);
		sqlSession.commit();
		sqlSession.close();
		return insertText;
	}

	//게시판안에 모든 게시글 가져오기
	@Override
	public List<TextVo> allText(int board_id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<TextVo> txtList = sqlSession.selectList("text.allText",board_id);
		sqlSession.close();;
		return txtList;
	}

	//게시글 하나 조회
	@Override
	public TextVo getText(int text_id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		TextVo textVo = sqlSession.selectOne("text.getText",text_id);
		sqlSession.close();;
		return textVo;
	}

	@Override
	public int updateText(TextVo textVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int update = sqlSession.update("text.updateText",textVo);
		sqlSession.commit();
		sqlSession.close();
		return update;
	}

	@Override
	public int changeCol(int text_id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int update = sqlSession.update("text.changeCol",text_id);
		sqlSession.commit();
		sqlSession.close();
		return update;
	}

	@Override
	public int insertReply(TextVo textVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int insertReply = (Integer) sqlSession.insert("text.insertReply",textVo);
		sqlSession.commit();
		sqlSession.close();
		return insertReply;
	}

	@Override
	public TextVo recentReply() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		TextVo textVo = sqlSession.selectOne("text.recentReply");
		sqlSession.close();
		return textVo;
	}
}
