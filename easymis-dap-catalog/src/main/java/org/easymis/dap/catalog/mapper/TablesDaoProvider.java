package org.easymis.dap.catalog.mapper;

import java.text.MessageFormat;
import java.util.List;

import org.easymis.dap.catalog.entity.Tables;

public class TablesDaoProvider {
	   /*
    批量增加
     */
	public String insert(List<Tables> list) {
		StringBuilder sb = new StringBuilder();
		sb.append("insert into dam_tables(table_id,dbs_id,table_name) values");
		MessageFormat mf = new MessageFormat("(#'{'list[{0}].tableId},#'{'list[{0}].dbsId},#'{'list[{0}].tableName})");
		for (int i = 0; i < list.size(); i++) {
			// sb.append("(");
			sb.append(mf.format(new Object[] { i }));
			// sb.append("0");
			if (i < list.size() - 1) {
				sb.append(",");
			}
		}
		return sb.toString();
	}

}
