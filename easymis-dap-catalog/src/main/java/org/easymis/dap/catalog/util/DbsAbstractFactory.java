package org.easymis.dap.catalog.util;

import java.util.List;

import org.easymis.dap.catalog.entity.Columns;
import org.easymis.dap.catalog.entity.Tables;

public interface DbsAbstractFactory {
	List<Tables> getTables();

	List<Columns> getColumns();
}
