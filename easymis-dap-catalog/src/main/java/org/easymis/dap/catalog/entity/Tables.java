package org.easymis.dap.catalog.entity;

public class Tables {
	private String tableId;
	private String dbsId;
	private String tableName;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
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
