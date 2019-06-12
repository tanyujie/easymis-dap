package org.easymis.dap.catalog.entity;

public class Business {
	private String businessId;
	private String ruleName;
	private String catalogId;
	private String ruleType;
	private Integer status;
	private String depict;

	public String getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}

	public String getRuleType() {
		return ruleType;
	}

	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public String getDepict() {
		return depict;
	}

	public void setDepict(String depict) {
		this.depict = depict;
	}

}
