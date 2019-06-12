package kr.or.ddit.db.file.dao;

import java.util.List;

import kr.or.ddit.db.file.model.FileVo;
import kr.or.ddit.mybatis.MyBatisUtil;

import org.apache.ibatis.session.SqlSession;

public class FileDao implements IfileDao {

	@Override
	public int insertFile(FileVo fileVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int insertFile = (Integer) sqlSession.insert("file.insertFile",fileVo);
		sqlSession.commit();
		sqlSession.close();
		return insertFile;
	}

	@Override
	public List<FileVo> fileList(int text_id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<FileVo> fileList = sqlSession.selectList("file.fileList",text_id);
		sqlSession.close();;
		return fileList;
	}

	@Override
	public FileVo getfile(int file_id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		FileVo fileVo1 = sqlSession.selectOne("file.getfile",file_id);
		sqlSession.close();;
		return fileVo1;
	}

	@Override
	public int del(int file_id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int del = sqlSession.delete("file.del",file_id);
		sqlSession.commit();
		sqlSession.close();
		return del;
	}

}
