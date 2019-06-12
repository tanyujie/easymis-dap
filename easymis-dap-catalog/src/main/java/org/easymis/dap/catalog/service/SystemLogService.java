package org.easymis.dap.catalog.service;

import java.util.Date;
import java.util.List;

import org.easymis.dap.catalog.entity.Dbs;
import org.easymis.dap.catalog.entity.SystemLog;
import org.easymis.dap.catalog.mapper.LogMapper;
import org.easymis.dap.catalog.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SystemLogService {
	@Autowired
	private LogMapper logMapper;

	public Dbs findById(String roleId) {
		return logMapper.findById(roleId);
	}

	public boolean save(SystemLog bean) {
		boolean flag = false;
		try {
			bean.setLogId(UUIDUtils.getUUID());
			bean.setCreateDate(new Date());
			bean.setValid(true);
			logMapper.insertByBean(bean);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public List<SystemLog> findAll() {
		return logMapper.findAll();
	}
}
