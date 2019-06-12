package kr.or.ddit.db.text.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TextVo {
	private int text_id; //게시글아이디
	private int text_id2; //부모게시글아이디 = 게시글아이디
	private int board_id; //게시판아이디
	private String text_title; //제목
	private String text_content; //내용
	private Date text_date; //작성일시
	private String col; //게시글상태
	private String userid; //작성자
	private int	group_num; //그룹번호
	private int lv;

	public TextVo() {
	}
	
	/**
	 * @param text_id
	 * @param user_id
	 * @param text_id2
	 * @param board_id
	 * @param text_title
	 * @param text_content
	 * @param text_date
	 * @param col
	 */
	public TextVo(int text_id, int text_id2, int board_id,
			String text_title, String text_content, Date text_date, String col, String userid, int	group_num) {
		super();
		this.text_id = text_id;
		this.text_id2 = text_id2;
		this.board_id = board_id;
		this.text_title = text_title;
		this.text_content = text_content;
		this.text_date = text_date;
		this.col = col;
		this.userid = userid;
		this.group_num = group_num;
	}
	
	//답글 insert 생성자
	public TextVo(int text_id2,int board_id,String text_title,String text_content,String userid,int	group_num){
		this.text_id2 = text_id2;
		this.board_id = board_id;
		this.text_title = text_title;
		this.text_content = text_content;
		this.userid = userid;
		this.group_num = group_num;
	}
	
	
	public TextVo(int board_id, String text_title, String text_content, String userid){
		this.board_id = board_id;
		this.text_title = text_title;
		this.text_content = text_content;
		this.userid = userid;
	}
	
	public TextVo( String text_title, String text_content, int text_id){
	      this.text_title = text_title;
	      this.text_content = text_content;
	      this.text_id = text_id;
	      
	   }
	
	public TextVo(int text_id, int board_id, String userid, int group_num){
		this.text_id = text_id;
		this.board_id = board_id;
		this.userid = userid;
		this.group_num = group_num;
		
	}
	
	public int getText_id() {
		return text_id;
	}

	public void setText_id(int text_id) {
		this.text_id = text_id;
	}

	public String getUserid() {
		return userid;
	}

	public int getGroup_num() {
		return group_num;
	}

	public void setGroup_num(int group_num) {
		this.group_num = group_num;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getText_id2() {
		return text_id2;
	}

	public void setText_id2(int text_id2) {
		this.text_id2 = text_id2;
	}

	public int getBoard_id() {
		return board_id;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}

	public String getText_title() {
		return text_title;
	}

	public void setText_title(String text_title) {
		this.text_title = text_title;
	}

	public String getText_content() {
		return text_content;
	}

	public void setText_content(String text_content) {
		this.text_content = text_content;
	}

	public Date getText_date() {
		return text_date;
	}

	public void setText_date(Date text_date) {
		this.text_date = text_date;
	}

	public String getCol() {
		return col;
	}

	public void setCol(String col) {
		this.col = col;
	}
	
	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

	@Override
	public String toString() {
		return "TextVo [text_id=" + text_id + ", text_id2=" + text_id2
				+ ", board_id=" + board_id + ", text_title=" + text_title
				+ ", text_content=" + text_content + ", text_date=" + text_date
				+ ", col=" + col + ", userid=" + userid + ", group_num="
				+ group_num + ", lv=" + lv + "]";
	}

	
	
}
