package kr.or.ddit.db.text.service;

import java.util.List;

import kr.or.ddit.db.text.dao.ItextDao;
import kr.or.ddit.db.text.dao.TextDao;
import kr.or.ddit.db.text.model.TextVo;

public class TextService implements ItextService {

	private ItextDao dao;
	
	public TextService(){
		dao = new TextDao();
	}
	
	@Override
	public int insertText(TextVo textVo) {
		return dao.insertText(textVo);
	}

	@Override
	public List<TextVo> allText(int board_id) {
		return dao.allText(board_id);
	}

	@Override
	public TextVo getText(int text_id) {
		return dao.getText(text_id);
	}

	@Override
	public int updateText(TextVo textVo) {
		return dao.updateText(textVo);
	}

	@Override
	public int changeCol(int text_id) {
		return dao.changeCol(text_id);
	}

	@Override
	public int insertReply(TextVo textVo) {
		return dao.insertReply(textVo);
	}

	@Override
	public TextVo recentReply() {
		return dao.recentReply();
	}

}
