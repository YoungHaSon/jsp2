package kr.or.ddit.db.comment.model;

import java.util.Date;

public class CommentVo {

	private int com_id; // 댓글아이디
	private int text_id; // 게시글아이디
	private String userid; // 작성자
	private Date com_date; // 작성일시
	private String col; // 댓글상태
	private String com_content; // 내용

	public CommentVo() {
	}

	/**
	 * @param com_id
	 * @param text_id
	 * @param user_id
	 * @param com_content
	 * @param com_date
	 */
	public CommentVo(int com_id, int text_id, String userid,
			String com_content, Date com_date, String col) {
		super();
		this.com_id = com_id;
		this.text_id = text_id;
		this.userid = userid;
		this.com_content = com_content;
		this.com_date = com_date;
		this.col = col;
	}
	
	public CommentVo( int text_id, String userid,
			String com_content) {
		super();
		this.text_id = text_id;
		this.userid = userid;
		this.com_content = com_content;
	}
	
	

	public String getCol() {
		return col;
	}

	public void setCol(String col) {
		this.col = col;
	}

	public int getCom_id() {
		return com_id;
	}

	public void setCom_id(int com_id) {
		this.com_id = com_id;
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

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getcom_content() {
		return com_content;
	}

	public void setCom_content(String com_content) {
		this.com_content = com_content;
	}

	public Date getCom_date() {
		return com_date;
	}

	public void setCom_date(Date com_date) {
		this.com_date = com_date;
	}

	@Override
	public String toString() {
		return "CommentVo [com_id=" + com_id + ", text_id=" + text_id
				+ ", userid=" + userid + ", com_content=" + com_content
				+ ", com_date=" + com_date + ", col=" + col + "]";
	}

	
}
