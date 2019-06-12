package org.easymis.dap.catalog.entity;

public class Columns {

	private String columnId;
	private String tableId;
	private String dbsId;
	private String columnName;

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnId() {
		return columnId;
	}

	public void setColumnId(String columnId) {
		this.columnId = columnId;
	}

	public String getTableId() {
		return tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public String getDbsId() {
		return dbsId;
	}

	public void setDbsId(String dbsId) {
		this.dbsId = dbsId;
	}

}
