package org.easymis.dap.catalog.config.log.annotation;

/**
 * 模块类型
 * 
 * @ClassName: ModuleType
 * @Description: TODO(模块类型)
 * @author lenovo-t
 * @date 2019年6月11日
 *
 */
public enum  ModuleType {
	DEFAULT("1"), // 默认值
    STUDENT("2"),// 学生模块
    TEACHER("3"); // 用户模块

	private ModuleType(String index) {
		this.module = index;	
	}

	private String module;

	public String getModule() {
		return this.module;
	}
}
