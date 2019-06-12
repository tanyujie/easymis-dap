package org.easymis.dap.catalog.config.log;

import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.easymis.dap.catalog.entity.SystemLog;
import org.easymis.dap.catalog.service.SystemLogService;
import org.easymis.dap.catalog.util.IPUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 系统日志
 *
 */
@Aspect
@Component
public class SystemLogAspect {

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private SystemLogService systemLogService;
	private static final String REQUEST_TYPE = "log";
	private static final String SUCCESS = "200";
	/**
	 * 建立日志对象线程变量
	 **/
	private ThreadLocal<SystemLog> threadLocal = new ThreadLocal<>();

	@Pointcut("execution(public * org.easymis.dap.catalog.controller..*.*(..))")
	public void webLog() {

	}

	@Before("webLog()")
	public void doBefore(JoinPoint point) {
		SystemLog systemLog = new SystemLog();
		try {
			// 获取请求对象
			RequestAttributes ra = RequestContextHolder.getRequestAttributes();
			ServletRequestAttributes sra = (ServletRequestAttributes) ra;
			HttpServletRequest request = sra.getRequest();

			systemLog.setUrl(request.getRequestURI());
			systemLog.setRequestType(REQUEST_TYPE);
			// 请求报文
			if (point.getArgs() != null && point.getArgs().length > 0) {
				Object parameterObject = point.getArgs()[0];
				if (parameterObject instanceof String) {
					systemLog.setRequestBody((String) parameterObject);
				} else {
					systemLog.setRequestBody(JSON.toJSONString(parameterObject));
				}
			}
			systemLog.setRequestMethod(request.getMethod());
			systemLog.setRequestDate(new Date());
			systemLog.setIp(IPUtils.getIpAddr(request));
			Enumeration<String> enu = request.getParameterNames();
			while (enu.hasMoreElements()) {
				String name = (String) enu.nextElement();
				logger.info("name:{},value:{}", name, request.getParameter(name));
			}
		} catch (Exception e) {
			logger.error("Before 日志记录报错！message:{}", e.getMessage());
			e.printStackTrace();
		}
		threadLocal.set(systemLog);

	}

	@AfterReturning(value = "webLog()", returning = "ret")
	public void after(Object ret) {
		logger.info("RESPONSE : " + ret);
		SystemLog systemLog = threadLocal.get();
		try {
			systemLog.setResponseDate(new Date());
			systemLog.setResponseBody(JSONObject.toJSONString(ret));
			systemLog.setResponseStatus(SUCCESS);
			systemLog.setResponseMessage("成功");
		} catch (Exception e) {
			logger.error("AfterReturning 日志记录报错！message:{}", e.getMessage());
			e.printStackTrace();
		}
		systemLogService.save(systemLog);
		threadLocal.remove();
	}

	@AfterThrowing(value = "webLog()", throwing = "throwing")
	public void error(Throwable throwing) {
		SystemLog systemLog = threadLocal.get();
		try {
			// 将报错信息写入error字段
			systemLog.setResponseDate(new Date());
			systemLog.setResponseMessage(throwing.getMessage());
			systemLog.setDepict(throwing.getStackTrace().length > 0 ? throwing.getStackTrace()[0].toString() : null);
			// 记录自定义的错误状态码
			// if (throwing instanceof ApiException) {
			// systemLog.setResponseStatus(String.valueOf(((ApiException)
			// throwing).getErrorCode()));
			// }
		} catch (Exception e) {
			logger.error("AfterThrowing 日志记录报错！message:{}", e.getMessage());
			e.printStackTrace();
		}
		systemLogService.save(systemLog);
		threadLocal.remove();
	}
}
