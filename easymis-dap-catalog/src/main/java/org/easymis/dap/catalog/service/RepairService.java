package org.easymis.dap.catalog.service;

import java.util.List;

import org.easymis.dap.catalog.entity.Repair;
import org.easymis.dap.catalog.mapper.RepairMapper;
import org.easymis.dap.catalog.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class RepairService {
	@Autowired
	private RepairMapper repairMapper;

	public Repair findById(String repairId) {
		return repairMapper.findById(repairId);
	}

	public boolean save(Repair bean) {
		boolean flag = false;
		try {
			bean.setRepairId(UUIDUtils.getUUID());
			repairMapper.insertByBean(bean);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public List<Repair> findAll() {
		return repairMapper.findAll();
	}
}
