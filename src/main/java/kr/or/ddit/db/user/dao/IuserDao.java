package kr.or.ddit.db.user.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.db.text.model.TextVo;
import kr.or.ddit.db.user.model.UsersVo;

import org.apache.ibatis.session.SqlSession;

public interface IuserDao {
	
	/**
	* Method : getUser
	* 작성자 : PC13
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 정보 조회
	*/
	UsersVo getUser(String userId);
	
	/**
	* Method : textPagingList
	* 작성자 : PC13
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 게시글 페이징 리스트 조회
	*/
	List<TextVo> textPagingList(Map<String, Object> map);
	
	/**
	* Method : textCnt
	* 작성자 : PC13
	* 변경이력 :
	* @return
	* Method 설명 : 게시글 전체수 조회
	*/
	int textCnt(int board_id);
	/////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	* Method : userListForPassEncrypt
	* 작성자 : PC13
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 비밀번호 암호화 적용대상 사용자 전체 조회
	*/
	List<UsersVo> userListForPassEncrypt(SqlSession sqlSession);
	
	/**
	* Method : updateUserEncryptPass
	* 작성자 : PC13
	* 변경이력 :
	* @param sqlSession
	* @param userVo
	* @return
	* Method 설명 : 사용자 비밀번호 암호화 적용
	*/
	int updateUserEncryptPass(SqlSession sqlSession, UsersVo usersVo);
}
	

