package org.easymis.dap.catalog.config.log;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.easymis.dap.catalog.config.log.annotation.LogKey;
import org.easymis.dap.catalog.entity.OperateLog;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
@Component
public class OperateLogInfoGeneration {
	public void processingManagerLogMessage(ProceedingJoinPoint jp, OperateLog logBean, Method method) {
		Object[] args = jp.getArgs();
		if (args.length > 0) {
			JSONObject msgJson = new JSONObject();

			// 获取方法上参数的注解
			Annotation[][] methodAnnotations = method.getParameterAnnotations();
			for (int i = 0; i < args.length; i++) {
				Object arg = args[i];
				// 如果参数被 LogKey 注解了，则直接返回内容
				if (checkArgAnnotationWithIsLogKey(arg, i, methodAnnotations, msgJson)) {
					continue;
				}

				Field[] fs = arg.getClass().getDeclaredFields();
				for (Field f : fs) {
					Annotation[] ans = f.getAnnotations();
					for (Annotation an : ans) {
						if ((an instanceof LogKey) && (((LogKey) an).isLog())) {
							String fieldName = f.getName();
							// 如果注解的有定义keyName，则覆盖对象成员变量名称
							String fieldNameLogkey = ((LogKey) an).keyName();
							if (!StringUtils.isEmpty(fieldNameLogkey)) {
								fieldName = fieldNameLogkey;
							}
							try {
								f.setAccessible(true);
								Object fieldValue = f.get(arg);
								msgJson.put(fieldName, fieldValue);
							} catch (IllegalAccessException e) {
								e.printStackTrace();
							} finally {
								f.setAccessible(false);
							}
						}
					}
				}
				logBean.setContent(msgJson.toJSONString());
			}

		}
	}

	/**
	 * 如果方法参数被Logkey注解，则将获取整个类的信息
	 * 
	 * @param index
	 * @param methodAnnotations
	 * @param msgJson
	 * @return
	 */
	private boolean checkArgAnnotationWithIsLogKey(Object arg, int index, Annotation[][] methodAnnotations,
			JSONObject msgJson) {
		for (Annotation annotation : methodAnnotations[index]) {
			if (annotation instanceof LogKey) {
				LogKey logKey = ((LogKey) annotation);
				if (logKey.isLog()) {
					String keyName = logKey.keyName();
					msgJson.put(keyName, arg.toString());
				}
				break;
			}
		}
		return false;
	}
}
