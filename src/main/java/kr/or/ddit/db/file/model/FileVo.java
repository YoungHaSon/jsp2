package kr.or.ddit.db.file.model;

public class FileVo {

	private int file_id; // 첨부파일아이디
	private int text_id; // 게시글아이디
	private String file_path; // 첨부파일경로
	private String file_name; // 원본파일명

	public FileVo() {
	}

	/**
	 * @param file_id
	 * @param text_id
	 * @param file_path
	 * @param file_name
	 */
	public FileVo(int text_id, String file_path, String file_name) {
		super();
		this.text_id = text_id;
		this.file_path = file_path;
		this.file_name = file_name;
	}

	public int getFile_id() {
		return file_id;
	}

	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}

	public int getText_id() {
		return text_id;
	}

	public void setText_id(int text_id) {
		this.text_id = text_id;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	@Override
	public String toString() {
		return "FileVo [file_id=" + file_id + ", text_id=" + text_id
				+ ", file_path=" + file_path + ", file_name=" + file_name + "]";
	}
	
	
}
