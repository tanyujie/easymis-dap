package org.easymis.dap.catalog.service;

import java.util.List;

import org.easymis.dap.catalog.entity.Business;
import org.easymis.dap.catalog.entity.Dbs;
import org.easymis.dap.catalog.mapper.BusinessMapper;
import org.easymis.dap.catalog.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BusinessService {
	@Autowired
	private BusinessMapper businessMapper;

	public Business findById(String businessId) {
		return businessMapper.findById(businessId);
	}

	public boolean save(Business bean) {
		boolean flag = false;
		try {
			bean.setBusinessId(UUIDUtils.getUUID());
			businessMapper.insertByBean(bean);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public List<Business> findAll() {
		return businessMapper.findAll();
	}
}
