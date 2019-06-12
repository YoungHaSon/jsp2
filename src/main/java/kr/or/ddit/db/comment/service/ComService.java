package kr.or.ddit.db.comment.service;

import java.util.List;

import kr.or.ddit.db.comment.dao.ComDao;
import kr.or.ddit.db.comment.dao.IcomDao;
import kr.or.ddit.db.comment.model.CommentVo;

public class ComService implements icomService {

	private IcomDao dao;
	
	public ComService(){
		dao = new ComDao();
	}
	
	@Override
	public int insertCom(CommentVo comVo) {
		return dao.insertCom(comVo);
	}

	@Override
	public List<CommentVo> Comselect(int text_id) {
		return dao.Comselect(text_id);
	}

	@Override
	public int changeCol(int com_id) {
		return dao.changeCol(com_id);
	}

}
