/**
 * 
 */
package com.zhan.pag;

import java.util.List;

public class Pagination<T> {
	private int currentPage;
	private long total;
	private List<T> rows;
	private int pageSize;
	private int totalPages;
	
	public Pagination(int currentPage, long total, List<T> rows, int pageSize) {
		this.currentPage = currentPage;
		this.total = total;
		this.rows = rows;
		this.pageSize = pageSize;
		
		int t = (int)(total/pageSize);
		int t1 = (int)(total % pageSize == 0 ? 0 : 1);
		totalPages = t + t1;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
}
