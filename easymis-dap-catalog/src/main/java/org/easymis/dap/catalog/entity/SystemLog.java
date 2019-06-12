package org.easymis.dap.catalog.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SystemLog implements Serializable {
	private static final long serialVersionUID = 1L;
	private String logId;
	/**
	 * 请求url
	 */
	private String url;
	/**
	 * 请求类型
	 */
	private String requestType;
	/**
	 * 请求方式
	 */
	private String requestMethod;
	/**
	 * 请求报文
	 */
	private String requestBody;
	/**
	 * 请求时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date requestDate;
	/**
	 * 响应报文
	 */
	private String responseBody;
	/**
	 * 响应状态值
	 */
	private String responseStatus;
	/**
	 * 响应消息
	 */
	private String responseMessage;
	/**
	 * 响应时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date responseDate;
	/**
	 * 操作者IP地址
	 */
	private String ip;
	/**
	 * 备注
	 */
	private String depict;
	/**
	 * 创建人id
	 */
	private Long creatorId;
	/**
	 * 创建人名称
	 */
	private String creator;
	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date createDate;
	/**
	 * 是否有效
	 */
	private Boolean valid;

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getRequestMethod() {
		return requestMethod;
	}

	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}

	public String getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}

	public java.util.Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(java.util.Date requestDate) {
		this.requestDate = requestDate;
	}

	public String getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}

	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public java.util.Date getResponseDate() {
		return responseDate;
	}

	public void setResponseDate(java.util.Date responseDate) {
		this.responseDate = responseDate;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}


	public String getDepict() {
		return depict;
	}

	public void setDepict(String depict) {
		this.depict = depict;
	}

	public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public java.util.Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	public Boolean getValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

}
