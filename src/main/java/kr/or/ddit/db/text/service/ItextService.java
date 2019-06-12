package kr.or.ddit.db.text.service;

import java.util.List;

import kr.or.ddit.db.text.model.TextVo;

public interface ItextService {

	/**
	* Method : insertText
	* 작성자 : PC13
	* 변경이력 :
	* @param textVo
	* @return
	* Method 설명 : 게시글 등록
	*/
	int insertText(TextVo textVo);
	
	/**
	* Method : textVo
	* 작성자 : PC13
	* 변경이력 :
	* @param board_id
	* @return
	* Method 설명 : board에 쓰여진 text다 불러오기
	*/
	List<TextVo> allText (int board_id);
	
	/**
	* Method : getText
	* 작성자 : PC13
	* 변경이력 :
	* @param text_id
	* @return
	* Method 설명 : 해당 text 번호로 게시글 한개 조회
	*/
	TextVo getText (int text_id);
	
	/**
	* Method : updateText
	* 작성자 : PC13
	* 변경이력 :
	* @param textVo
	* @return
	* Method 설명 : 게시글 업데이트
	*/
	int updateText (TextVo textVo);
	
	/**
	* Method : changeCol
	* 작성자 : PC13
	* 변경이력 :
	* @param textVo
	* @return
	* Method 설명 : 게시글을 삭제하면 상태가 N으로 바뀌어요
	*/
	int changeCol(int text_id);
	
	/**
	* Method : insertReply
	* 작성자 : PC13
	* 변경이력 :
	* @param textVo
	* @return
	* Method 설명 : 답글작성
	*/
	int insertReply (TextVo textVo);
	
	
	/**
	* Method : recentReply
	* 작성자 : PC13
	* 변경이력 :
	* @return
	* Method 설명 : 가장 최근 글 vo가져옴
	*/
	TextVo recentReply();
}
