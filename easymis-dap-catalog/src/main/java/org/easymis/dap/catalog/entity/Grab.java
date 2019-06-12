package org.easymis.dap.catalog.entity;

import java.util.Date;

public class Grab {
	private String grabId;
	private String dbsId;
	private Date startTime;
	private Date finishTime;
	private Integer tableCount;
	private Integer columnCount;

	public String getGrabId() {
		return grabId;
	}

	public void setGrabId(String grabId) {
		this.grabId = grabId;
	}

	public String getDbsId() {
		return dbsId;
	}

	public void setDbsId(String dbsId) {
		this.dbsId = dbsId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public Integer getTableCount() {
		return tableCount;
	}

	public void setTableCount(Integer tableCount) {
		this.tableCount = tableCount;
	}

	public Integer getColumnCount() {
		return columnCount;
	}

	public void setColumnCount(Integer columnCount) {
		this.columnCount = columnCount;
	}

}
