package com.web2h.nan.persitence.dao.utils;

/**
 * Page bean to specify info about the range of data to retrieve in database.
 * 
 * @author Web2h
 */
public class Page {

	private final static int DEFAULT_PAGE_SIZE = 10;

	private int page = 0;

	private int size = DEFAULT_PAGE_SIZE;

	public Page(int page, int size) {
		this.page = page - 1;
		if (this.page < 0) {
			this.page = 0;
		}
		this.size = size;
	}

	public int getFirstResult() {
		return page * size;
	}

	public int getMaxResult() {
		return size;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setSize(int size) {
		this.size = size;
	}
}