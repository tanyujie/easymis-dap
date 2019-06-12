package org.easymis.dap.catalog.mapper;

import java.text.MessageFormat;
import java.util.List;

import org.easymis.dap.catalog.entity.Columns;

public class ColumnsDaoProvider {
	   /*
    批量增加
     */
	public String insert(List<Columns> list) {
		StringBuilder sb = new StringBuilder();
		sb.append("insert into dam_columns(COLUMN_id,dbs_id,table_id,COLUMN_NAME) values");
		MessageFormat mf = new MessageFormat(
				"(#'{'list[{0}].columnId},#'{'list[{0}].dbsId},#'{'list[{0}].tableId},#'{'list[{0}].columnName})");
		for (int i = 0; i < list.size(); i++) {
			sb.append(mf.format(new Object[] { i }));

			if (i < list.size() - 1) {
				sb.append(",");
			}
		}
		return sb.toString();
	}

}
