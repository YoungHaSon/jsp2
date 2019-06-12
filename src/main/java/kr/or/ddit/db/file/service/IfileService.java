package kr.or.ddit.db.file.service;

import java.util.List;

import kr.or.ddit.db.file.model.FileVo;

public interface IfileService {
	/**
	* Method : insertFile
	* 작성자 : PC13
	* 변경이력 :
	* @param fileVo
	* @return
	* Method 설명 : 첨부파일 등록
	*/
	int insertFile(FileVo fileVo);
	
	/**
	* Method : fileList
	* 작성자 : PC13
	* 변경이력 :
	* @param text_id
	* @return
	* Method 설명 : 해당 게시물의 첨부파일 리스트
	*/
	List<FileVo> fileList(int text_id);
	
	/**
	* Method : getfile
	* 작성자 : PC13
	* 변경이력 :
	* @param fileVo
	* @return
	* Method 설명 : 파일 하나의 정보
	*/
	FileVo getfile(int file_id);
	
	/**
	* Method : del
	* 작성자 : PC13
	* 변경이력 :
	* @param file_id
	* @return
	* Method 설명 : 첨부파일 하나지우는!
	*/
	int del(int file_id);
}
