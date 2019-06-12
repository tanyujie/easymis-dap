package org.easymis.dap.catalog.service;

import java.util.List;

import org.easymis.dap.catalog.entity.Inspect;
import org.easymis.dap.catalog.mapper.InspectMapper;
import org.easymis.dap.catalog.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class InspectService {
	@Autowired
	private InspectMapper inspectMapper;

	public Inspect findById(String businessId) {
		return inspectMapper.findById(businessId);
	}

	public boolean save(Inspect bean) {
		boolean flag = false;
		try {
			bean.setInspectId(UUIDUtils.getUUID());
			inspectMapper.insertByBean(bean);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public List<Inspect> findAll() {
		return inspectMapper.findAll();
	}
}
