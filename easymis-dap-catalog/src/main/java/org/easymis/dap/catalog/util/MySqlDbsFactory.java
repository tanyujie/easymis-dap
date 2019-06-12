package org.easymis.dap.catalog.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.easymis.dap.catalog.entity.Columns;
import org.easymis.dap.catalog.entity.Dbs;
import org.easymis.dap.catalog.entity.Tables;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class MySqlDbsFactory implements DbsAbstractFactory {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private Dbs dbs;
	private List columnsList;

	public MySqlDbsFactory(Dbs dbs) {
		super();
		this.dbs = dbs;
		columnsList = new ArrayList();
		StringBuffer sb = new StringBuffer();
		sb.append("jdbc:mysql://");
		sb.append(dbs.getHost());
		sb.append(":");
		sb.append(dbs.getPort());
		sb.append("/");
		sb.append("information_schema");
		sb.append("?characterEncoding=utf8&useSSL=false");
		dataSource = new DriverManagerDataSource(sb.toString(), dbs.getUsername(), dbs.getPassword());
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Tables> getTables() {

		StringBuffer sql = new StringBuffer();
		sql.append("select * from tables where table_schema=?");
		// sql.append(dbs.getDbsName());

		List<Map<String, Object>> tablesList = jdbcTemplate.queryForList(sql.toString(),
				new Object[] { dbs.getDbsName() });
		List tList = new ArrayList();
		for (int i = 0; i < tablesList.size(); i++) {
			Tables table = new Tables();
			table.setTableId(UUIDUtils.getUUID());
			table.setDbsId(dbs.getDbsId());
			String tableName = tablesList.get(i).get("TABLE_NAME").toString();
			table.setTableName(tableName);
			if (tableName != null) {
				StringBuffer columnsSql = new StringBuffer();
				columnsSql.append("select * from COLUMNS where table_schema=? and table_name=?");
				//sql.append(dbs.getDbsName());

				List<Map<String, Object>> cList = jdbcTemplate.queryForList(columnsSql.toString(),new Object[] { dbs.getDbsName(),table.getTableName() });
				for (int j = 0; j < cList.size(); j++) {
					Columns column = new Columns();
					column.setColumnId(UUIDUtils.getUUID());
					column.setDbsId(dbs.getDbsId());
					column.setTableId(table.getTableId());
					column.setColumnName(cList.get(j).get("COLUMN_NAME").toString());
					columnsList.add(column);
				}
			}

			tList.add(table);
		}
		return tList;
	}

	@Override
	public List<Columns> getColumns() {

		return columnsList;
	}

}
