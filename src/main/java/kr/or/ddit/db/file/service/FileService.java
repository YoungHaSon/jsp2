package kr.or.ddit.db.file.service;

import java.util.List;

import kr.or.ddit.db.file.dao.FileDao;
import kr.or.ddit.db.file.dao.IfileDao;
import kr.or.ddit.db.file.model.FileVo;

public class FileService implements IfileService {

	private IfileDao dao;

	// UserDao에 있는 것을 쓰기위해!! 필요!
	public FileService() {
		dao = new FileDao();
	}
	
	@Override
	public int insertFile(FileVo fileVo) {
		return dao.insertFile(fileVo);
	}

	@Override
	public List<FileVo> fileList(int text_id) {
		return dao.fileList(text_id);
	}

	@Override
	public FileVo getfile(int file_id) {
		return dao.getfile(file_id);
	}

	@Override
	public int del(int file_id) {
		return dao.del(file_id);
	}

}
