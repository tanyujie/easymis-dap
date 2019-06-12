package org.easymis.dap.catalog.service;

import java.util.List;

import org.easymis.dap.catalog.config.log.annotation.EventType;
import org.easymis.dap.catalog.config.log.annotation.LogEnable;
import org.easymis.dap.catalog.config.log.annotation.LogEvent;
import org.easymis.dap.catalog.config.log.annotation.ModuleType;
import org.easymis.dap.catalog.entity.Dbs;
import org.easymis.dap.catalog.entity.Role;
import org.easymis.dap.catalog.mapper.RoleMapper;
import org.easymis.dap.catalog.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@LogEnable // 启动日志拦截
@LogEvent(module = ModuleType.STUDENT)
public class RoleService {
	@Autowired
	private RoleMapper roleMapper;

	public Dbs findById(String roleId) {
		return roleMapper.findById(roleId);
	}
	@LogEvent(event = EventType.ADD, desc = "保存记录") // 添加日志标识
	public boolean save(Role bean) {
		boolean flag = false;
		try {
			bean.setRoleId(UUIDUtils.getUUID());
			bean.setPriority(1);
			bean.setIsSuper(false);
			bean.setSystemDefault(false);
			roleMapper.insertByBean(bean);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public List<Role> findAll() {
		return roleMapper.findAll();
	}
}
