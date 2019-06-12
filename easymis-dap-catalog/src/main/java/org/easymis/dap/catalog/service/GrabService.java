package org.easymis.dap.catalog.service;

import java.util.Date;

import org.easymis.dap.catalog.entity.Dbs;
import org.easymis.dap.catalog.entity.Grab;
import org.easymis.dap.catalog.mapper.ColumnsMapper;
import org.easymis.dap.catalog.mapper.GrabMapper;
import org.easymis.dap.catalog.mapper.TablesMapper;
import org.easymis.dap.catalog.util.DbsAbstractFactory;
import org.easymis.dap.catalog.util.MySqlDbsFactory;
import org.easymis.dap.catalog.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




@Service
@Transactional
public class GrabService {
	@Autowired
	private TablesMapper tablesMapper;
	@Autowired
	private ColumnsMapper columnsMapper;
	@Autowired
	private GrabMapper grabMapper;
	
	public boolean save(Dbs bean) {
		boolean flag = false;
		try {
			Grab grab= new Grab();
			grab.setGrabId(UUIDUtils.getUUID());
			grab.setDbsId(bean.getDbsId());
			grab.setStartTime(new Date());
			DbsAbstractFactory dbsFactory = new MySqlDbsFactory(bean);
			tablesMapper.insertByList(dbsFactory.getTables());
			columnsMapper.insertByList(dbsFactory.getColumns());
			grab.setTableCount(dbsFactory.getTables().size());
			grab.setColumnCount(dbsFactory.getColumns().size());
			grab.setFinishTime(new Date());
			grabMapper.insertByBean(grab);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
