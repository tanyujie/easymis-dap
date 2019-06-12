package org.easymis.dap.catalog.web;

import java.util.List;

public class DataTableResult {
	private int draw;// 绘制计数器

	private int recordsTotal;// 没有过滤的记录数

	private int recordsFiltered;// 过滤后的记录数

	private List<?> data;// 返回数据

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public int getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}
	
}
