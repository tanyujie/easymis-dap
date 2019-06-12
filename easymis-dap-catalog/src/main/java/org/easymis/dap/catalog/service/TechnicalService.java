package org.easymis.dap.catalog.service;

import java.util.List;

import org.easymis.dap.catalog.entity.Technical;
import org.easymis.dap.catalog.mapper.TechnicalMapper;
import org.easymis.dap.catalog.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TechnicalService {
	@Autowired
	private TechnicalMapper technicalMapper;

	public Technical findById(String technicalId) {
		return technicalMapper.findById(technicalId);
	}

	public boolean save(Technical bean) {
		boolean flag = false;
		try {
			bean.setTechnicalId(UUIDUtils.getUUID());
			//technicalMapper.insertByDbs(bean);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public List<Technical> findAll() {
		return technicalMapper.findAll();
	}
}
