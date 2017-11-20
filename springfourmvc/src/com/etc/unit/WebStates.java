package com.etc.unit;

public class WebStates {
	private Integer page;
	private Integer pageSize;
	private String key;
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public WebStates() {
		// TODO Auto-generated constructor stub
	}
	public WebStates(Integer page, Integer pageSize, String key) {
		super();
		this.page = page;
		this.pageSize = pageSize;
		this.key = key;
	}
	

}
