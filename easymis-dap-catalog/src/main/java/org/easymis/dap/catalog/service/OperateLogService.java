package org.easymis.dap.catalog.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.easymis.dap.catalog.entity.LoginLog;
import org.easymis.dap.catalog.entity.OperateLog;
import org.easymis.dap.catalog.mapper.OperateLogMapper;
import org.easymis.dap.catalog.util.UUIDUtils;
import org.easymis.dap.catalog.web.DataTableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class OperateLogService {
	@Autowired
	private OperateLogMapper operateLogMapper;

	public OperateLog findById(String operateLogId) {
		return operateLogMapper.findById(operateLogId);
	}

	public boolean save(OperateLog bean) {
		boolean flag = false;
		try {
			bean.setOperateLogId(UUIDUtils.getUUID());
			bean.setCreateDate(new Date());
			operateLogMapper.insertByBean(bean);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public List<OperateLog> findAll() {
		return operateLogMapper.findAll();
	}
	public DataTableResult  findAll(Map<String, Object> map, int page, int rows) {
        PageHelper.startPage(page, rows);
        DataTableResult result=new DataTableResult();
		List<OperateLog> itemList = operateLogMapper.findAll();
		result.setData(itemList);
		PageInfo<OperateLog> info=new PageInfo<>(itemList);
		result.setRecordsTotal((int) info.getTotal());
		result.setRecordsFiltered((int) info.getTotal());

		return result;
		
	}
}
