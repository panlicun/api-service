package com.plc.vo;

public class PageVo {

	private int pageId;
	private int pageSize;
	private int totalCount;
	private Long vedioTypeId;
	private String vedioName;

	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public Long getVedioTypeId() {
		return vedioTypeId;
	}

	public void setVedioTypeId(Long vedioTypeId) {
		this.vedioTypeId = vedioTypeId;
	}

	public String getVedioName() {
		return vedioName;
	}

	public void setVedioName(String vedioName) {
		this.vedioName = vedioName;
	}
	

}
