package kr.or.ddit.db.user.model;

public class PageVo {

	private int page;	//페이지 번호
	private int pageSize;	//페이지당 건수
	
	// 이것들의 역할???
	public PageVo(int page, int pageSize){
		this.page = page;
		this.pageSize = pageSize;
	}
	
	public PageVo() {
		
	}
	//
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public String toString() {
		return "pageVo [page=" + page + ", pageSize=" + pageSize + "]";
	}
	
	
	
}
