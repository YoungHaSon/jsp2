package kr.or.ddit.db.board.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardVo {
	private int board_id; // 게시판아이디
	private String userid; // 생성자
	private String board_name; // 게시판 이름
	private String use_yn; // 사용여부
	private Date reg_dt; // 생성일시
	

	public BoardVo() {
	}

	/**
	 * @param board_id
	 * @param user_id
	 * @param board_name
	 * @param use_yn
	 * @param reg_dt
	 */

	public BoardVo(String userid, String board_name,String use_yn) {
		super();
		this.userid = userid;
		this.board_name = board_name;
		this.use_yn = use_yn;
	}
	
	public BoardVo(int board_id, String board_name,String use_yn) {
		super();
		this.board_id = board_id;
		this.board_name = board_name;
		this.use_yn = use_yn;
	}

	// birth를 찍느....
	public String getBirthStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(reg_dt);
		if (date == null) {
			return "";
		}
		return date;
	}

	public int getBoard_id() {
		return board_id;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getBoard_name() {
		return board_name;
	}

	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}

	public String getUse_yn() {
		return use_yn;
	}

	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}

	public Date getReg_dt() {
		return reg_dt;
	}

	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}

	@Override
	public String toString() {
		return "BoardVo [board_id=" + board_id + ", userid=" + userid
				+ ", board_name=" + board_name + ", use_yn=" + use_yn
				+ ", reg_dt=" + reg_dt + "]";
	}

	


	
}
