package org.easymis.dap.catalog.entity;

import java.util.Date;

public class OperateLog {
	private String operateLogId;
	private String creatorId;
	private String creator;
	private String belongType;
	private String operationTypeName;
	private String belongTypeName;
	private String objectName;
	private Date createDate;
	private String ip;
	private String depict;
	private String content;

	public String getOperateLogId() {
		return operateLogId;
	}

	public String getDepict() {
		return depict;
	}

	public void setDepict(String depict) {
		this.depict = depict;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setOperateLogId(String operateLogId) {
		this.operateLogId = operateLogId;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getBelongType() {
		return belongType;
	}

	public void setBelongType(String belongType) {
		this.belongType = belongType;
	}

	public String getOperationTypeName() {
		return operationTypeName;
	}

	public void setOperationTypeName(String operationTypeName) {
		this.operationTypeName = operationTypeName;
	}

	public String getBelongTypeName() {
		return belongTypeName;
	}

	public void setBelongTypeName(String belongTypeName) {
		this.belongTypeName = belongTypeName;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
