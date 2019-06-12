package org.easymis.dap.catalog.service;

import java.util.List;

import org.easymis.dap.catalog.entity.Dbs;
import org.easymis.dap.catalog.mapper.DbsMapper;
import org.easymis.dap.catalog.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DbsService {
	@Autowired
	private DbsMapper dbsMapper;

	public Dbs findById(String dbsId) {
		return dbsMapper.findById(dbsId);
	}

	public boolean save(Dbs bean) {
		boolean flag = false;
		try {
			bean.setDbsId(UUIDUtils.getUUID());
			dbsMapper.insertByDbs(bean);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public List<Dbs> findAll() {
		return dbsMapper.findAll();
	}
}
