package com.it.domian;

import java.util.List;

/**
 * 用于封装分页的数据
 * 学生集合
 * 总记录数,总页数,当前页,每页记录数
 * @author admin
 *
 */
public class PageBean<T> {
	
	private int currentPage;
	private int totalPage;
	private int pageSize;
	private int totalSize;
	private List<T> list;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
}
